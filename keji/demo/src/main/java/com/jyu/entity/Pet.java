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
    private String owner;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet() {
    }

    public Pet(String name, String owner, int age) {
        this.name = name;
        this.owner = owner;
        this.age = age;
    }
}
