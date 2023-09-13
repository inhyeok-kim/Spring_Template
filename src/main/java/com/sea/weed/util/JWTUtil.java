package com.sea.weed.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sea.weed.model.JWTModel;
import com.sea.weed.model.ResponseModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
    private final static String KEY = "SeAwEeDkIm";
    
    public static String createToken(Map<String,Object> payloads, Date expiredTime, String subject){
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        // 토큰 Builder
        String jwt = Jwts.builder()
                .setHeader(headers) // Headers 설정
                .setClaims(payloads) // Claims 설정
                .setSubject(subject) // 토큰 용도 
                .setExpiration(expiredTime) // 토큰 만료 시간 설정
                .signWith(SignatureAlgorithm.HS256, KEY.getBytes()) // HS256과 Key로 Sign
                .compact(); // 토큰 생성

        return jwt;
    }

    public static JWTModel verifyToken(String jwt) {
        JWTModel result = new JWTModel();
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(KEY.getBytes("UTF-8")) // Set Key
                    .parseClaimsJws(jwt) // 파싱 및 검증, 실패 시 에러
                    .getBody();

            result.setStatus(0);
            result.setClaims(claims);

        } catch (ExpiredJwtException e) { // 토큰이 만료되었을 경우
            result.setStatus(1);
            result.setMessage("토큰 만료");
        } catch (Exception e) { // 그외 에러났을 경우
            result.setStatus(2);
            result.setMessage("에러");
        }
        return result;
    }    
}
