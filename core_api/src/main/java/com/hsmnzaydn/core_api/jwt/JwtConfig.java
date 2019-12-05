package com.hsmnzaydn.core_api.jwt;

import org.springframework.beans.factory.annotation.Value;

public class JwtConfig {

    public static final String SECRET = "term--commands";
    public static final long EXPIRATION_TIME = 5 * 60 * 60; // 5 gün
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/users/register";




}