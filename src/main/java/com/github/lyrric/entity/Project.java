package com.github.lyrric.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Project {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 开始时间
     */
    private LocalDate startDate;

    /**
     * 结束时间
     */
    private LocalDate endDate;

    /**
     * 介绍
     */
    private String description;

    public static List<Project> getDefaultData(){
        List<Project> data = new ArrayList<>();
        Project e = new Project();
        e.setDescription("项目采用spring boot进行开发，mysql作为数据库");
        e.setName("xxx管理系统");
        e.setEndDate(LocalDate.of(2018,9,7));
        e.setStartDate(LocalDate.of(2014,9,7));
        data.add(e);
        e = new Project();
        e.setDescription("图书馆管理系统，管理学校的图书借阅，图书管理等信息");
        e.setName("图书馆管理系统");
        e.setEndDate(LocalDate.of(2020,9,7));
        e.setStartDate(LocalDate.of(2018,9,7));
        data.add(e);
        return data;
    }
}