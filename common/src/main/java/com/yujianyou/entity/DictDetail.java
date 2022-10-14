package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 数据字典详情(DictDetail)实体类
 *
 * @author yujianyou
 * @since 2021-11-25 19:28:36
 */

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findDictDetailByName",
                query = "select t1.* from system.sys_dict_detail t1 left join system.sys_dict t2 on t1.dict_id = t2.dict_id where t1.name =?1",
                resultClass = DictDetail.class
        )
})


@Entity
@Getter
@Setter
@Table(name = "system.sys_dict_detail")
@TableName("system.sys_dict_detail")
@Schema(description = "DictDetail实体")
public class DictDetail extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @Column(name = "detail_id")
    private Long id;

    /**
     * 字典id
     */
    @JoinColumn(name = "dict_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Dict dict;

    /**
     * 字典标签
     */
    @Column(name = "label")
    private String label;

    /**
     * 字典值
     */
    @Column(name = "value")
    private String value;

    /**
     * 排序
     */
    @Column(name = "dict_sort")
    private Integer dictSort;


}

