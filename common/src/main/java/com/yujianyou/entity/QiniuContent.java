/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 上传成功后，存储结果
 *
 * @author Zheng Jie
 * @date 2018-12-31
 */
@Data
@Entity
@Table(name = "system.tool_qiniu_content")
@TableName("system.tool_qiniu_content")
public class QiniuContent extends PanacheEntityBase implements Serializable {

    @Id
    @Column(name = "content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 文件名
     */
    @Column(name = "name")
    private String key;
    /**
     * 空间名
     */
    private String bucket;
    /**
     * 大小
     */
    private String size;
    /**
     * 文件地址
     */
    private String url;
    /**
     * 文件类型
     */
    private String suffix;
    /**
     * 空间类型：公开/私有
     */
    private String type = "公开";
    /**
     * 创建或更新时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;
}
