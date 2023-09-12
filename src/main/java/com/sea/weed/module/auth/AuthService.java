package com.sea.weed.module.auth;

import org.springframework.stereotype.Service;

import com.sea.weed.model.AuthModel;
import com.sea.weed.model.ResponseModel;
import com.sea.weed.model.UserModel;

@Service
public class AuthService {


    public ResponseModel doLogin(AuthModel auth) throws Exception{
        ResponseModel response = new ResponseModel();
        if(auth.getId().equals("test") && auth.getPassword().equals("test")){
            UserModel user = new UserModel();
            user.setId(auth.getId());
            user.setName("테스터");
            response.put("user",user);
            response.setStatus(0);
            response.setMessage("로그인 성공");
        } else {
            response.setStatus(1);
            response.setMessage("로그인 실패");
        }
        
        return response;
    }

    
}
