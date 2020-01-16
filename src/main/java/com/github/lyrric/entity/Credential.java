package com.github.lyrric.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Credential {

    /**
     * 内容
     */
    private String content;

    public static List<Credential> getDefaultData(){
        List<Credential> data = new ArrayList<>();
        Credential e = new Credential();
        e.setContent("英语四级证书");
        data.add(e);
        e = new Credential();
        e.setContent("二级计算等级证书");
        data.add(e);
        return data;
    }
}