package com.thunisoft.demo.PageNavigationSystem.controller;

import javax.servlet.http.HttpServletRequest;

import com.thunisoft.artery.data.annotation.DataTranslate;
import com.thunisoft.demo.PageNavigationSystem.model.Ljxx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LjxxFormController Controller
 * 
 *
 * @author Thunisoft
 * @date 2020-07-28
 */
@Controller
@RequestMapping("/api/v1/ljxxForm")
public class LjxxFormController {
    /**
     * html模板入口
     * @return 'resources/templates'下的html模板
     */
    @GetMapping()
    @DataTranslate
    public String index(HttpServletRequest request,Ljxx ljxx) {
        if(ljxx == null){
            ljxx = new Ljxx();
        }
        request.setAttribute("formData",ljxx);
        return "ljxxForm";
 	}

}