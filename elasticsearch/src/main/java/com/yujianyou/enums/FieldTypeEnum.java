package com.yujianyou.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yujianyou
 * @date 2022/1/5 10:45
 * @email 597907730@qq.com
 */
@Getter
@AllArgsConstructor
public enum FieldTypeEnum {
    // string
    TEXT("text"),
    KEYWORD("keyword"),
    // Numeric
    INTEGER("integer"),
    LONG("long"),
    SHORT("short"),
    BYTE("byte"),
    DOUBLE("double"),
    FLOAT("float"),
    HALF_FLOAT("half_float"),
    SCALED_FLOAT("scaled_float"),
    // Date
    DATE("date"),
    // Date nanoseconds
    DATE_NANOS("date_nanos"),
    // Boolean
    BOOLEAN("boolean"),
    // Binary
    BINARY("binary"),
    // Range
    INTEGER_RANGE("integer_range"),
    FLOAT_RANGE("float_range"),
    LONG_RANGE("long_range"),
    DOUBLE_RANGE("double_range"),
    DATE_RANGE("date_range"),
    IP_RANGE("ip_range"),

    // Object
    OBJECT("object"),

    // Nested
    NESTED("nested"),
    // Geo datatypes
    GEO_POINT("geo_point"),
    GEO_SHAPE("geo_shape"),
    // IP
    IP("ip"),
    // Completion datatype
    COMPLETION("completion "),
    // Token count
    TOKEN_COUNT("token_count"),
    // murmur3
    MURMUR3("murmur3"),
    // maper-annotated-text
    ANNOTATED_TEXT("annotated-text"),

    ;


    private String type;

}
