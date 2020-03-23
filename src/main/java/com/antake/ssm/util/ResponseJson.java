package com.antake.ssm.util;

import com.alibaba.fastjson.JSONObject;

public final class ResponseJson {
    private ResponseJson(){}
    public static JSONObject respJson(int code,String message){
        JSONObject json=new JSONObject();
        json.put("code",code);
        json.put("message",message);
        return json;
    }
}

