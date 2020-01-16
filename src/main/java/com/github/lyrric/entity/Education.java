package com.github.lyrric.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Education {

    /**
     * 开始时间
     */
    private LocalDate startDate;

    /**
     * 结束时间
     */
    private LocalDate endDate;

    /**
     * 学校名
     */
    private String college;

    /**
     * 专业
     */
    private String specialty;

    /**
     * 本科/专科
     */
    private String type;

    /**
     * 主修课程
     */
    private String courses;

    public static List<Education> getDefaultData(){
        List<Education> data = new ArrayList<>();
        Education e = new Education();
        e.setCollege("清华大学");
        e.setCourses("JAVA，高等数学");
        e.setEndDate(LocalDate.of(2020,9,7));
        e.setStartDate(LocalDate.of(2018,9,7));
        e.setSpecialty("软件工程");
        e.setType("本科");
        data.add(e);
        e = new Education();
        e.setCollege("北京大学");
        e.setCourses("JAVA,计算机网络，操作系统");
        e.setEndDate(LocalDate.of(2020,9,7));
        e.setStartDate(LocalDate.of(2018,9,7));
        e.setSpecialty("软件工程");
        e.setType("硕士");
        data.add(e);
        return data;
    }

}