package com.github.lyrric.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
public class Job {

    /**
     * 开始时间
     */

    private LocalDate startDate;

    /**
     * 结束时间
     */

    private LocalDate endDate;

    /**
     * 公司
     */
    private String company;

    /**
     * 职位
     */
    private String position;

    /**
     * 描述
     */
    private String description;

    public static List<Job> getDefaultData(){
        List<Job> data = new ArrayList<>();
        Job e = new Job();
        e.setCompany("XXX科技有限公司");
        e.setDescription("接口开发，用Spring boot开发");
        e.setEndDate(LocalDate.of(2018,9,7));
        e.setStartDate(LocalDate.of(2014,9,7));
        e.setPosition("JAVA工程师");
        data.add(e);
        e = new Job();
        e.setCompany("阿里巴巴科技有限公司");
        e.setDescription("阿里巴巴软件部门，从事java开发");
        e.setEndDate(LocalDate.of(2020,9,7));
        e.setStartDate(LocalDate.of(2018,9,7));
        e.setPosition("JAVA工程师");
        data.add(e);
        return data;
    }
}