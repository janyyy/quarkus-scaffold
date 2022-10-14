package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 数据字典(Dict)实体类
 *
 * @author yujianyou
 * @since 2021-11-25 19:28:36
 */


@Entity
@Getter
@Setter
@Table(name = "system.sys_dict")
@TableName("system.sys_dict")
@Schema(description = "Dict实体")
public class Dict extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @Column(name = "dict_id")
    private Long id;

    /**
     * 字典名称
     */
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "dict", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<DictDetail> dictDetails;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;


}

