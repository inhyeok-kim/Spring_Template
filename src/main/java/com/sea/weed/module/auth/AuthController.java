package com.sea.weed.module.auth;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseModel login(HttpServletRequest req, HttpServletResponse res,@RequestBody AuthModel auth) throws Exception{
        ResponseModel result = new ResponseModel();
        
        System.out.println(auth.getId());

        ResponseModel loginResult = authService.doLogin(auth);
        if(loginResult.getStatus() > 0){
            result.setStatus(1);
            result.setMessage("로그인 실패");
        } else {
            result.setMessage("로그인 성공");
            result.put("accessToken",loginResult.get("accessToken"));
            Cookie cookie = new Cookie("accessToken",(String)loginResult.get("accessToken"));
            cookie.setMaxAge(60 * 60 * 24 * 30);
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            res.addCookie(cookie);
        }

        return result;
    }
}
