package com.jyu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name="tbl_user")//关联表
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自动主键自增
    private Long id;
    @NotNull(message = "用户名不能为空")
    private String name;
    private Date birthday;
    private int age;
}
