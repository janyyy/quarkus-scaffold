package com.yujianyou.query;


import com.yujianyou.annotation.Query;
import com.yujianyou.base.PageEntity;
import lombok.Data;


@Data
public class LogQuery extends PageEntity {

    @Query
    private String username;

    @Query
    private String logType;

}

