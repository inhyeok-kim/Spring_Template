package com.sea.weed.model;

import io.jsonwebtoken.Claims;
import lombok.Data;

@Data
public class JWTModel {
    private Claims claims;
    private int status;
    private String message;
}
