package com.yujianyou.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.dto.MenuDto;
import com.yujianyou.entity.Menu;
import com.yujianyou.entity.User;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.mapstruct.MenuMapper;
import com.yujianyou.query.MenuQuery;
import com.yujianyou.repository.MenuRepository;
import com.yujianyou.service.MenuService;
import com.yujianyou.service.UserService;
import com.yujianyou.utils.PageUtil;
import com.yujianyou.utils.QueryHelper;
import com.yujianyou.utils.StringUtil;
import com.yujianyou.vo.MenuMetaVo;
import com.yujianyou.vo.MenuVo;
import io.quarkus.panache.common.Sort;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 系统菜单业务实现层
 *
 * @author yujianyou
 * @since 2021-12-06 12:47:36
 */
@Slf4j
@ApplicationScoped
public class MenuServiceImpl implements MenuService {

    @Inject
    MenuRepository menuRepository;

    @Inject
    UserService userService;

    @Inject
    MenuMapper menuMapper;

    @Context
    SecurityContext securityContext;

    @Inject
    EntityManager entityManager;

    /**
     * 查询列表
     *
     * @param menuQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(MenuQuery menuQuery, Boolean isQuery) throws IllegalAccessException {
        List<String> sortList = new ArrayList<>();
        sortList.add("menuSort,asc");
        menuQuery.setPage(0);
        menuQuery.setSize(999999);
        menuQuery.setSort(sortList);
        if (Boolean.TRUE.equals(isQuery)) {
            menuQuery.setPidIsNull(true);
            List<Field> fields = QueryHelper.getAllFields(menuQuery.getClass(), new ArrayList<>());
            for (Field field : fields) {
                //设置对象的访问权限，保证对private的属性的访问
                field.setAccessible(true);
                Object val = field.get(menuQuery);
                String name = field.getName();
                if ("pidIsNull".equals(name)) {
                    continue;
                }
                if (!"page".equals(name) && !"size".equals(name) && !"sort".equals(name)) {
                    if (ObjectUtil.isNotNull(val)) {
                        menuQuery.setPidIsNull(null);
                        break;
                    }
                }

            }
        }

        // 获取 TypedQuery
        Map<String, Object> map = QueryHelper.createQuery(entityManager, Menu.class, menuQuery);

        List<Menu> list = (List<Menu>) map.get("content");
        List<MenuDto> resultList = menuMapper.toDto(list);
        return PageUtil.toPage(resultList, Convert.toInt(map.get("totalElements")));
    }

    /**
     * 构建菜单树
     *
     * @param menuDtos 原始数据
     * @return /
     */
    @Override
    public List<MenuDto> buildTree(List<MenuDto> menuDtos) {
        List<MenuDto> trees = new ArrayList<>();
        Set<Long> ids = new HashSet<>();
        for (MenuDto menuDTO : menuDtos) {
            if (menuDTO.getPid() == null) {
                trees.add(menuDTO);
            }
            for (MenuDto it : menuDtos) {
                if (menuDTO.getId().equals(it.getPid())) {
                    if (menuDTO.getChildren() == null) {
                        menuDTO.setChildren(new ArrayList<>());
                    }
                    menuDTO.getChildren().add(it);
                    ids.add(it.getId());
                }
            }
        }
        if (trees.size() == 0) {
            trees = menuDtos.stream().filter(s -> !ids.contains(s.getId())).collect(Collectors.toList());
        }
        return trees;
    }

    /**
     * 构建菜单树
     *
     * @param menuDtos /
     * @return /
     */
    @Override
    public List<MenuVo> buildMenus(List<MenuDto> menuDtos) {
        List<MenuVo> list = new LinkedList<>();
        menuDtos.forEach(menuDTO -> {
            if (menuDTO != null) {
                List<MenuDto> menuDtoList = menuDTO.getChildren();
                MenuVo menuVo = new MenuVo();
                menuVo.setName(ObjectUtil.isNotEmpty(menuDTO.getComponentName()) ? menuDTO.getComponentName() : menuDTO.getTitle());
                // 一级目录需要加斜杠，不然会报警告
                menuVo.setPath(menuDTO.getPid() == null ? "/" + menuDTO.getPath() : menuDTO.getPath());
                menuVo.setHidden(menuDTO.getHidden());
                // 如果不是外链
                if (!menuDTO.getIFrame()) {
                    if (menuDTO.getPid() == null) {
                        menuVo.setComponent(StringUtil.isBlank(menuDTO.getComponent()) ? "Layout" : menuDTO.getComponent());
                        // 如果不是一级菜单，并且菜单类型为目录，则代表是多级菜单
                    } else if (menuDTO.getType() == 0) {
                        menuVo.setComponent(StringUtil.isBlank(menuDTO.getComponent()) ? "ParentView" : menuDTO.getComponent());
                    } else if (StringUtil.isNotBlank(menuDTO.getComponent())) {
                        menuVo.setComponent(menuDTO.getComponent());
                    }
                }
                menuVo.setMeta(new MenuMetaVo(menuDTO.getTitle(), menuDTO.getIcon(), !menuDTO.getCache()));
                if (CollectionUtil.isNotEmpty(menuDtoList)) {
                    menuVo.setAlwaysShow(true);
                    menuVo.setRedirect("noredirect");
                    menuVo.setChildren(buildMenus(menuDtoList));
                    // 处理是一级菜单并且没有子菜单的情况
                } else if (menuDTO.getPid() == null) {
                    MenuVo menuVo1 = new MenuVo();
                    menuVo1.setMeta(menuVo.getMeta());
                    // 非外链
                    if (!menuDTO.getIFrame()) {
                        menuVo1.setPath("index");
                        menuVo1.setName(menuVo.getName());
                        menuVo1.setComponent(menuVo.getComponent());
                    } else {
                        menuVo1.setPath(menuDTO.getPath());
                    }
                    menuVo.setName(null);
                    menuVo.setMeta(null);
                    menuVo.setComponent("Layout");
                    List<MenuVo> list1 = new ArrayList<>();
                    list1.add(menuVo1);
                    menuVo.setChildren(list1);
                }
                list.add(menuVo);
            }
        });
        return list;
    }

    /**
     * 查找当前登录用户菜单
     *
     * @param username /
     * @return /
     */
    @Override
    public List<MenuDto> findMenuByUserName(String username) {
        User user = userService.findCurrentUser(username);
        String sql = "select * from system.sys_menu t1 left join system.sys_roles_menus t2 on t1.menu_id = t2.menu_id left join system.sys_users_roles t3 on t2.role_id = t3.role_id where t3.user_id =? and t1.hidden = false and t1.type != 2 order by t1.menu_sort asc";
        List<Menu> list = entityManager.createNativeQuery(sql, Menu.class).setParameter(1, user.getId()).getResultList();
        return menuMapper.toDto(list);
    }

    /**
     * 查找指定用户权限信息
     *
     * @param userId /
     * @return /
     */
    @Override
    public List<String> findCurrentUserPermission(Long userId) {
        String sql = "select DISTINCT * from system.sys_menu t1 left join system.sys_roles_menus t2 on t1.menu_id = t2.menu_id left join system.sys_users_roles t3 on t2.role_id = t3.role_id where t3.user_id =?1 and t1.permission is not null";
        List<Menu> list = entityManager.createNativeQuery(sql, Menu.class).setParameter(1, userId).getResultList();
        return list.stream().map(Menu::getPermission).collect(Collectors.toList());
    }

    /**
     * 懒加载菜单数据
     *
     * @param pid /
     * @return /
     */
    @Override
    public List<MenuDto> getMenus(Long pid) {
        List<Menu> menus;
        if (pid != null && !pid.equals(0L)) {
            menus = Menu.find("pid=?1", Sort.by("menuSort").ascending(), pid).list();
        } else {
            menus = Menu.list("pid is null", Sort.by("menuSort").ascending());
        }
        return menuMapper.toDto(menus);
    }

    /**
     * 根据菜单ID返回所有子节点ID，包含自身ID
     *
     * @param id /
     * @return /
     */
    @Override
    public Set<Long> child(Long id) {
        Set<Menu> menuSet = new HashSet<>();
        List<MenuDto> menuList = getMenus(id);
        menuSet.add(menuRepository.findById(id));
        menuSet = getChildMenus(menuMapper.toEntity(menuList), menuSet);
        return menuSet.stream().map(Menu::getId).collect(Collectors.toSet());
    }

    /**
     * 查询菜单:根据ID获取同级与上级数据
     *
     * @param ids /
     * @return /
     */
    @Override
    public List<MenuDto> getSuperior(List<Long> ids) {
        Set<MenuDto> menuDtos = new LinkedHashSet<>();
        if (CollectionUtil.isNotEmpty(ids)) {
            for (Long id : ids) {
                Menu menu = Menu.findById(id);
                MenuDto menuDto = menuMapper.toDto(menu);
                menuDtos.addAll(getSuperior1(menuDto, new ArrayList<>()));
            }
            return buildTree(new ArrayList<>(menuDtos));
        }
        return getMenus(null);
    }

    private List<MenuDto> getSuperior1(MenuDto menuDto, List<Menu> menus) {
        if (menuDto.getPid() == null) {
            menus.addAll(Menu.find("pid is null").list());
            return menuMapper.toDto(menus);
        }
        menus.addAll(Menu.find("pid =?1", menuDto.getPid()).list());
        Menu menu = Menu.findById(menuDto.getPid());
        return getSuperior1(menuMapper.toDto(menu), menus);
    }

    /**
     * 获取所有子节点，包含自身ID
     *
     * @param menuList /
     * @param menuSet  /
     * @return /
     */
    @Override
    public Set<Menu> getChildMenus(List<Menu> menuList, Set<Menu> menuSet) {
        for (Menu menu : menuList) {
            menuSet.add(menu);
            List<Menu> menus = Menu.find("pid=?1", menu.getId()).list();
            if (menus != null && menus.size() != 0) {
                getChildMenus(menus, menuSet);
            }
        }
        return menuSet;
    }

    /**
     * 新增
     *
     * @param menu /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(Menu menu) {
        Optional<Menu> title = Menu.find("title =?1", menu.getTitle()).firstResultOptional();
        if (title.isPresent()) {
            throw new BadRequestException("标题标题已存在！");
        }
        if (StringUtil.isNotBlank(menu.getComponentName())) {
            Optional<Menu> componentName = Menu.find("componentName =?1", menu.getComponentName()).firstResultOptional();
            if (componentName.isPresent()) {
                throw new BadRequestException("组件名称已存在！");
            }
        }
        if (menu.getPid().equals(0L)) {
            menu.setPid(null);
        }

        if (menu.getIFrame()) {
            String http = "http://", https = "https://";
            if (!(menu.getPath().toLowerCase().startsWith(http) || menu.getPath().toLowerCase().startsWith(https))) {
                throw new BadRequestException("外链必须以http://或者https://开头");
            }
        }

        menuRepository.persist(menu);
        // 计算子节点数目
        menu.setSubCount(0);
        // 更新父节点菜单数目
        updateSubCnt(menu.getPid());
    }

    private void updateSubCnt(Long menuId) {
        if (menuId != null) {
            Menu menu = Menu.findById(menuId);
            long count = Menu.count("pid =?1", menuId);
            menu.setSubCount((int) count);
        }
    }

    /**
     * 修改
     *
     * @param resources /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(Menu resources) {
        if (resources.getId().equals(resources.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        Menu menu = Menu.findById(resources.getId());
        if (ObjectUtil.isNull(menu.getId())) {
            throw new BadRequestException("查询菜单信息异常");
        }
        if (resources.getIFrame()) {
            String http = "http://", https = "https://";
            if (!(resources.getPath().toLowerCase().startsWith(http) || resources.getPath().toLowerCase().startsWith(https))) {
                throw new BadRequestException("外链必须以http://或者https://开头");
            }
        }

        Optional<Menu> menu1 = Menu.find("title =?1", resources.getTitle()).firstResultOptional();
        if (menu1.isPresent() && !menu1.get().getId().equals(menu.getId())) {
            throw new BadRequestException("菜单名称已存在！");
        }

        if (resources.getPid().equals(0L)) {
            resources.setPid(null);
        }

        // 记录的父节点ID
        Long oldPid = menu.getPid();
        Long newPid = resources.getPid();
        if (StringUtil.isNotBlank(resources.getComponentName())) {
            menu1 = Menu.find("componentName =?1", resources.getComponentName()).firstResultOptional();
            if (menu1.isPresent() && !menu1.get().getId().equals(menu.getId())) {
                throw new BadRequestException("组件名称已存在！");
            }
        }
        menu.setTitle(resources.getTitle());
        menu.setComponent(resources.getComponent());
        menu.setPath(resources.getPath());
        menu.setIcon(resources.getIcon());
        menu.setIFrame(resources.getIFrame());
        menu.setPid(resources.getPid());
        menu.setMenuSort(resources.getMenuSort());
        menu.setCache(resources.getCache());
        menu.setHidden(resources.getHidden());
        menu.setComponentName(resources.getComponentName());
        menu.setPermission(resources.getPermission());
        menu.setType(resources.getType());

        // 计算父级菜单节点数目
        updateSubCnt(oldPid);
        updateSubCnt(newPid);
    }

    /**
     * 删除
     *
     * @param ids /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteAll(List<Long> ids) {
        Set<Menu> menuSet = new HashSet<>();
        for (Long id : ids) {
            List<MenuDto> menuList = getMenus(id);
            menuSet.add(Menu.findById(id));
            menuSet = getChildMenus(menuMapper.toEntity(menuList), menuSet);
        }
        // 菜单删除
        Menu.delete("id in ?1", ids);

    }


}

