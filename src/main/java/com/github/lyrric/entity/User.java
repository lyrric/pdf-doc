package com.github.lyrric.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    /**
     * 真实名字
     */
    private String realName;

    /**
     * 身高
     */
    private Integer stature;

    /**
     * 民族
     */
    private String nation;

    /**
     * 教育
     */
    private String education;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 毕业院校
     */
    private String college;

    /**
     * 住址
     */
    private String address;

    /**
     * 求职意向
     */
    private String jobIntention;

    /**
     * 头像
     */
    private String profilePhoto;


    /**
     * 自我介绍
     */
    private String introduction;

    public static User getDefaultData(){
        User e = new User();
        e.setRealName("王小明");
        e.setProfilePhoto("images/avatar.jpg");
        e.setStature(178);
        e.setNation("汉族");
        e.setEducation("硕士");
        e.setTel("1860828****");
        e.setBirthday(LocalDate.of(1989,9,7));
        e.setEmail("xx20510@163.com");
        e.setIntroduction("本人有高度的事业心与责任心，良好的职业道德，原则性强，工作认真，积极主动，能吃苦耐劳，在工作和生活中能够不断吸取新的知识充实自己，并能从实际出发全面考虑问题，有信心向新工作挑战，和同事关系融洽!我愿到贵公司工作。我希望能与其它员工一起为贵公司奉献自己的一份力量，同时也体现自己的人生价值。");
        e.setCollege("清华大学");
        e.setAddress("四川成都");
        e.setJobIntention("JAVA工程师");
        e.setIntroduction("爱好学习，热爱专研,有丰富的开发经验。");
        return e;
    }
}