package com.sea.weed;

import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.sea.weed.model.JWTModel;
import com.sea.weed.model.ResponseModel;
import com.sea.weed.util.JWTUtil;

import io.jsonwebtoken.Claims;


@SpringBootTest
@ActiveProfiles("dev")
class SeaWeedApplicationTests {
    
    @Test
    void test(){
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("id", "test");
        Date expiredTime = new Date();
        expiredTime.setTime(expiredTime.getTime()+(1000 * 60L * 60L * 24L));
        String jwt = JWTUtil.createToken(payload, expiredTime, "test");
        System.out.println("JWT :: " +jwt);

        JWTModel result = JWTUtil.verifyToken(jwt);

        if(result.getStatus() > 0){
            System.out.println(result.getMessage());
        } else {
            Claims claims = (Claims)result.getClaims();
            System.out.println(claims.get("id"));
        }

    }
}
