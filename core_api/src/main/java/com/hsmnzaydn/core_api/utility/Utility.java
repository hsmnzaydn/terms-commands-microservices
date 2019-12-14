package com.hsmnzaydn.core_api.utility;

import com.hsmnzaydn.core_api.CommonResponse;

public class Utility {

    public static  <T>CommonResponse commonErrorResponseFactory(){
        CommonResponse<T> commonResponse=new CommonResponse<>();
        commonResponse.setMessage("Şuan sunucu yoğun");
        commonResponse.setCode(500);

        return commonResponse;
    }


    public static <T>CommonResponse commonResponseFactory(T body){
        CommonResponse<T> commonResponse=new CommonResponse<>();
        commonResponse.setData(body);
        commonResponse.setCode(200);
        return commonResponse;
    }
}
