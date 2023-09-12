package com.sea.weed.module.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sea.weed.config.properties.TestProperties;
import com.sea.weed.model.AuthModel;
import com.sea.weed.model.ResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseModel login(HttpServletRequest req, @RequestBody AuthModel auth) throws Exception{
        ResponseModel result = new ResponseModel();
        
        ResponseModel loginResult = authService.doLogin(auth);
        if(loginResult.getStatus() > 0){
            result.setStatus(1);
            result.setMessage("로그인 실패");
        } else {
            result.setMessage("로그인 성공");
            result.put("user",loginResult.get("user"));
        }

        return result;
    }
}
