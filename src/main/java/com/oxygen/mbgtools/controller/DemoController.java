package com.oxygen.mbgtools.controller;


import lombok.extern.slf4j.Slf4j;
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


    /**
     * http://127.0.0.1:8082/demo/demo
     * @return
     */
    @RequestMapping("demo")
    public String demo(){
        return "success";
    }
}
