package com.sea.weed.module.auth;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.sea.weed.model.AuthModel;
import com.sea.weed.model.ResponseModel;
import com.sea.weed.model.UserModel;
import com.sea.weed.util.JWTUtil;

@Service
public class AuthService {


    public ResponseModel doLogin(AuthModel auth) throws Exception{
        ResponseModel response = new ResponseModel();
        if(auth.getId().equals("test") && auth.getPassword().equals("test")){
            UserModel user = new UserModel();
            user.setSeq(0);
            user.setId(auth.getId());
            user.setName("테스터");
            response.put("user",user);
            response.setStatus(0);
            response.setMessage("로그인 성공");

            String accessToken = createAccessToken(user);
            response.put("accessToken",accessToken);
        } else {
            response.setStatus(1);
            response.setMessage("로그인 실패");
        }
        
        return response;
    }

    public String createAccessToken(UserModel user){
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("seq", user.getSeq());
        payload.put("name", user.getName());

        Date expiredTime = new Date();
        expiredTime.setTime(expiredTime.getTime()+(1000 * 60L * 5L)); // 5분

        String jwt = JWTUtil.createToken(payload, expiredTime, "access");

        return jwt;
    }

    
}
