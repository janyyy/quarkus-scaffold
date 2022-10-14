package com.yujianyou.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.yujianyou.base.UploadEntity;
import com.yujianyou.entity.QiniuConfig;
import com.yujianyou.entity.QiniuContent;
import com.yujianyou.query.QiniuQueryCriteria;
import com.yujianyou.repository.QiniuConfigRepository;
import com.yujianyou.repository.QiniuContentRepository;
import com.yujianyou.service.QiNiuService;
import com.yujianyou.utils.QiNiuUtil;
import com.yujianyou.utils.QueryHelper;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author yujianyou
 * @date 2022/1/14 14:58
 * @email 597907730@qq.com
 */
@Slf4j
@ApplicationScoped
public class QiNiuServiceImpl implements QiNiuService {

    @Inject
    QiniuConfigRepository qiNiuConfigRepository;

    @Inject
    QiniuContentRepository qiniuContentRepository;

    @Inject
    EntityManager entityManager;

    /**
     * 查配置
     *
     * @return QiniuConfig
     */
    @Override
    public QiniuConfig find(Long id) {
        Optional<QiniuConfig> qiniuConfig = qiNiuConfigRepository.findByIdOptional(id);
        return qiniuConfig.orElseGet(QiniuConfig::new);
    }

    /**
     * 修改配置
     *
     * @param qiniuConfig 配置
     * @return QiniuConfig
     */
    @Override
    public QiniuConfig updateConfig(QiniuConfig qiniuConfig) {
        String http = "http://", https = "https://";
        if (!(qiniuConfig.getHost().toLowerCase().startsWith(http) || qiniuConfig.getHost().toLowerCase().startsWith(https))) {
            throw new RuntimeException("外链域名必须以http://或者https://开头");
        }
        qiNiuConfigRepository.persist(qiniuConfig);
        return qiniuConfig;
    }

    /**
     * 分页查询
     *
     * @param criteria 条件
     * @return /
     */
    @Override
    public Object queryAll(QiniuQueryCriteria criteria) {
        return QueryHelper.createQuery(entityManager, QiniuContent.class, criteria);
    }

    /**
     * 查询全部
     *
     * @param criteria 条件
     * @return /
     */
    @Override
    public List<QiniuContent> queryAllList(QiniuQueryCriteria criteria) {
        return QueryHelper.createQueryReturn(entityManager, QiniuContent.class, criteria).getResultList();
    }

    /**
     * 上传文件
     *
     * @param file        文件
     * @param qiniuConfig 配置
     * @return QiniuContent
     */
    @Override
    public QiniuContent upload(UploadEntity file, QiniuConfig qiniuConfig) {
//        if (qiniuConfig.getId() == null) {
//            throw new RuntimeException("请先添加相应配置，再操作");
//        }
//        // 构造一个带指定Zone对象的配置类
//        Configuration cfg = new Configuration(QiNiuUtil.getRegion(qiniuConfig.getZone()));
//        UploadManager uploadManager = new UploadManager(cfg);
//        Auth auth = Auth.create(qiniuConfig.getAccessKey(), qiniuConfig.getSecretKey());
//        String upToken = auth.uploadToken(qiniuConfig.getBucket());
//        try {
//            String key = file.getOriginalFilename();
//            if(qiniuContentRepository.findByKey(key) != null) {
//                key = QiNiuUtil.getKey(key);
//            }
//            Response response = uploadManager.put(file.getFile().getBytes(), key, upToken);
//            //解析上传成功的结果
//
//            DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
//            QiniuContent content = qiniuContentRepository.findByKey(FileUtil.getFileNameNoEx(putRet.key));
//            if(content == null){
//                //存入数据库
//                QiniuContent qiniuContent = new QiniuContent();
//                qiniuContent.setSuffix(FileUtil.getExtensionName(putRet.key));
//                qiniuContent.setBucket(qiniuConfig.getBucket());
//                qiniuContent.setType(qiniuConfig.getType());
//                qiniuContent.setKey(FileUtil.getFileNameNoEx(putRet.key));
//                qiniuContent.setUrl(qiniuConfig.getHost()+"/"+putRet.key);
//                qiniuContent.setSize(FileUtil.getSize(Integer.parseInt(file.getSize()+"")));
//                return qiniuContentRepository.save(qiniuContent);
//            }
//            return content;
//        } catch (Exception e) {
//            throw new BadRequestException(e.getMessage());
//        }
        return null;
    }

    /**
     * 查询文件
     *
     * @param id 文件ID
     * @return QiniuContent
     */
    @Override
    public QiniuContent findByContentId(Long id) {
        return qiniuContentRepository.findByIdOptional(id).orElseGet(QiniuContent::new);
    }

    /**
     * 下载文件
     *
     * @param content 文件信息
     * @param config  配置
     * @return String
     */
    @Override
    public String download(QiniuContent content, QiniuConfig config) {
        String finalUrl;
        String type = "公开";
        if (type.equals(content.getType())) {
            finalUrl = content.getUrl();
        } else {
            Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
            // 1小时，可以自定义链接过期时间
            long expireInSeconds = 3600;
            finalUrl = auth.privateDownloadUrl(content.getUrl(), expireInSeconds);
        }
        return finalUrl;
    }

    /**
     * 删除文件
     *
     * @param content 文件
     * @param config  配置
     */
    @Override
    public void delete(QiniuContent content, QiniuConfig config) throws QiniuException {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(QiNiuUtil.getRegion(config.getZone()));
        Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
        BucketManager bucketManager = new BucketManager(auth, cfg);
        bucketManager.delete(content.getBucket(), content.getKey() + "." + content.getSuffix());
    }

    /**
     * 同步数据
     *
     * @param config 配置
     */
    @Override
    public void synchronize(QiniuConfig config) {
        if (config.getId() == null) {
            throw new RuntimeException("请先添加相应配置，再操作");
        }
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(QiNiuUtil.getRegion(config.getZone()));
        Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //文件名前缀
        String prefix = "";
        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
        //列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(config.getBucket(), prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            QiniuContent qiniuContent;
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                if (qiniuContentRepository.find("key=?1", QiNiuUtil.getFileNameNoEx(item.key)) == null) {
                    qiniuContent = new QiniuContent();
                    qiniuContent.setSize(QiNiuUtil.getSize(Integer.parseInt(item.fsize + "")));
                    qiniuContent.setSuffix(QiNiuUtil.getExtensionName(item.key));
                    qiniuContent.setKey(QiNiuUtil.getFileNameNoEx(item.key));
                    qiniuContent.setType(config.getType());
                    qiniuContent.setBucket(config.getBucket());
                    qiniuContent.setUrl(config.getHost() + "/" + item.key);
                    qiniuContentRepository.persist(qiniuContent);
                }
            }
        }
    }

    /**
     * 删除文件
     *
     * @param ids    文件ID数组
     * @param config 配置
     */
    @Override
    public void deleteAll(Long[] ids, QiniuConfig config) throws QiniuException {
        for (Long id : ids) {
            delete(findByContentId(id), config);
        }
    }

    /**
     * 更新数据
     *
     * @param type 类型
     */
    @Override
    public void update(String type) {
        qiNiuConfigRepository.update("type=?1", type);
    }


}
