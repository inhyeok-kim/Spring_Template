package com.sea.weed.module.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.weed.config.properties.TestProperties;
import com.sea.weed.model.UserModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestProperties testProperties;


    @RequestMapping("")
    public String index(HttpServletRequest req) throws Exception{
        UserModel user = (UserModel) req.getAttribute("user");

        System.out.println(user.toString());

        String result = testService.getTest();

        log.info("Test : {}",testProperties.test);

        return result;
    }
}
