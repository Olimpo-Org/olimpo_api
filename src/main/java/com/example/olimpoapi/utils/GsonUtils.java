package com.example.olimpoapi.utils;

import com.google.gson.Gson;

public class GsonUtils {
    public String toJson(Object object) {
        return new Gson().toJson(object);
    }
    public <T> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }
}
