package com.github.lyrric.controller;

import com.github.lyrric.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created on 2020-01-19.
 *
 * @author wangxiaodong
 */
@Controller
public class HtmlController {

    /**
     * html页面
     * @param model
     * @return
     */
    @GetMapping(value = "/html")
    public String userIndex(Model model){
        model.addAttribute("user", User.getDefaultData());
        model.addAttribute("credentials", Credential.getDefaultData());
        model.addAttribute("educations", Education.getDefaultData());
        model.addAttribute("jobs", Job.getDefaultData());
        model.addAttribute("projects", Project.getDefaultData());
        return "user-index";
    }
}
