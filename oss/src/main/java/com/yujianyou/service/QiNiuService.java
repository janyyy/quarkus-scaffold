package com.yujianyou.service;

import com.qiniu.common.QiniuException;
import com.yujianyou.base.UploadEntity;
import com.yujianyou.entity.QiniuConfig;
import com.yujianyou.entity.QiniuContent;
import com.yujianyou.query.QiniuQueryCriteria;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.util.List;

/**
 * 七牛云配置
 */
public interface QiNiuService {

    /**
     * 查配置
     *
     * @return QiniuConfig
     */
    QiniuConfig find(Long id);

    /**
     * 修改配置
     *
     * @param qiniuConfig 配置
     * @return QiniuConfig
     */
    QiniuConfig updateConfig(QiniuConfig qiniuConfig);

    /**
     * 分页查询
     *
     * @param criteria 条件
     * @return /
     */
    Object queryAll(QiniuQueryCriteria criteria);

    /**
     * 查询全部
     *
     * @param criteria 条件
     * @return /
     */
    List<QiniuContent> queryAllList(QiniuQueryCriteria criteria);

    /**
     * 上传文件
     *
     * @param file        文件
     * @param qiniuConfig 配置
     * @return QiniuContent
     */
    QiniuContent upload(@MultipartForm UploadEntity file, QiniuConfig qiniuConfig);

    /**
     * 查询文件
     *
     * @param id 文件ID
     * @return QiniuContent
     */
    QiniuContent findByContentId(Long id);

    /**
     * 下载文件
     *
     * @param content 文件信息
     * @param config  配置
     * @return String
     */
    String download(QiniuContent content, QiniuConfig config);

    /**
     * 删除文件
     *
     * @param content 文件
     * @param config  配置
     */
    void delete(QiniuContent content, QiniuConfig config) throws QiniuException;

    /**
     * 同步数据
     *
     * @param config 配置
     */
    void synchronize(QiniuConfig config);

    /**
     * 删除文件
     *
     * @param ids    文件ID数组
     * @param config 配置
     */
    void deleteAll(Long[] ids, QiniuConfig config) throws QiniuException;

    /**
     * 更新数据
     *
     * @param type 类型
     */
    void update(String type);
}
