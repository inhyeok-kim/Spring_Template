package com.sea.weed.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sea.weed.model.JWTModel;
import com.sea.weed.model.ResponseModel;
import com.sea.weed.model.UserModel;
import com.sea.weed.util.JWTUtil;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

/**
 * TestInterceptor
 */
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
        String accessToken = request.getHeader("X-Auth-Access") == null ? "" : request.getHeader("X-Auth-Access");
		JWTModel result = JWTUtil.verifyToken(accessToken);
        if(accessToken.equals("")){
            log.info("미인증 요청");
			response.sendError(401, "Not Authorized");
			return false;
        } else if(result.getStatus()==0) {
            Claims claims = result.getClaims();
            UserModel user = new UserModel();
            user.setSeq((int)claims.get("seq"));
            user.setName((String)claims.get("name"));
            System.out.println(user.toString());
            request.setAttribute("user", user);
			return true;
		}else if(result.getStatus() == 1){
            log.info("토큰 만료");
			response.sendError(401, "Not Authorized");
			return false;
		}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
    }
}