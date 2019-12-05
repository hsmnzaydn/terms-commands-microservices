package com.hsmnzaydn.core_api.jwt;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter        // lombok will create getters auto.
@ToString        // [IMP] You need to install lombok jar file: https://stackoverflow.com/a/11807022
public class JwtConfig {


    public static String Uri ="/api/users/register" ;


    public static String header= "Authorization";


    public static String prefix= "Bearer";


    public static int expiration= 24*60*60;


    public static String secret = "terms";



}
