package com.sachinlakshitha.springbootjdbcmysqlcrudrediscache.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CustomerDto implements Serializable {
    private String id;
    private String name;
    private String email;
    private Date createdTime;
}
