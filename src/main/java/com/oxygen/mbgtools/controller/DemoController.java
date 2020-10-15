package com.oxygen.mbgtools.controller;


import com.oxygen.mbgtools.base.annotation.ApiLogRegister;
import com.oxygen.mbgtools.service.impl.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 * @author oxygen
 * @date 2020/7/8
 **/
@Slf4j
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;


    /**
     * http://127.0.0.1:8082/demo/demo
     * @return
     */
    @RequestMapping("demo")
    public String demo(){
        return "success";
    }

    /**
     * http://127.0.0.1:8082/demo/save
     * @return
     */
    @ApiLogRegister(name="ssssss")
    @RequestMapping("save")
    public String save(){
        demoService.save();
        return "save";
    }
}
