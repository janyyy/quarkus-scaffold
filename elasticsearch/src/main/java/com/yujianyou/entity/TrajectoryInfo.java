package com.yujianyou.entity;


import com.yujianyou.annotation.Field;
import com.yujianyou.enums.FieldTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


/**
 * @author yujianyou
 * @date 2022/1/5 10:50
 * @email 597907730@qq.com
 */
@Getter
@Setter
public class TrajectoryInfo implements Serializable {


    private Long id;

    /**
     * 客户编号
     */
    @Field(type = FieldTypeEnum.KEYWORD)
    private String customerNumber;
    /**
     * 产品编码
     */
    @Field(type = FieldTypeEnum.KEYWORD)
    private String productCode;

    @Field(type = FieldTypeEnum.KEYWORD)
    private String trackNumber;

    /**
     * 100时间，以此类推
     */
    @Field(type = FieldTypeEnum.DATE)
    private Date track100OpTime;

    @Field
    private String track100OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track200OpTime;

    @Field
    private String track200OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track300OpTime;

    @Field
    private String track300OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track301OpTime;

    @Field
    private String track301OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track400OpTime;

    @Field
    private String track400OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track401OpTime;

    @Field
    private String track401OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track402OpTime;

    @Field
    private String track402OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track403OpTime;

    @Field
    private String track403OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track404OpTime;

    @Field
    private String track404OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track405OpTime;

    @Field
    private String track405OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track500OpTime;

    @Field
    private String track500OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track501OpTime;

    @Field
    private String track501OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track600OpTime;

    @Field
    private String track600OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track700OpTime;


    @Field
    private String track700OpLocation;

    @Field(type = FieldTypeEnum.DATE)
    private Date track701OpTime;

    @Field
    private String track701OpLocation;
    /**
     * 创建时间
     */
    @Field(type = FieldTypeEnum.DATE)
    private Date createTime;
}
