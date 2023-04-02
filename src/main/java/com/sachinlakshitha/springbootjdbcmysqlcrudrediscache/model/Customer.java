package com.sachinlakshitha.springbootjdbcmysqlcrudrediscache.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Customer implements Serializable {
    private String id;
    private String name;
    private String email;
    private Date createdTime;
}
