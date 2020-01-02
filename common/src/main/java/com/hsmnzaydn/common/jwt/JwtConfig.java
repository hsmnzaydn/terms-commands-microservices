package com.hsmnzaydn.common.jwt;

import lombok.Getter;
import lombok.ToString;

@Getter        // lombok will create getters auto.
@ToString        // [IMP] You need to install lombok jar file: https://stackoverflow.com/a/11807022
public class JwtConfig {


    public static String Uri ="/api/users/register" ;


    public static String header= "Authorization";


    public static String prefix= "Bearer";


    public static int expiration= 24*60*60;


    public static String secret = "terms";



}
