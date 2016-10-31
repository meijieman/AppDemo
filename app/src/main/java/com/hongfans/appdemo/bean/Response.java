package com.hongfans.appdemo.bean;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2016/10/31.
 */
public class Response<T> {

    public int    code;
    public String msg;
    public T      data;

    public static <T> Response<T> fromJson(String json, Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(Response.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public static <T> String toJson(Response<T> response, Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(Response.class, clazz);
        return gson.toJson(response, objectType);
    }

    private static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }

    @Override
    public String toString() {
        return "Response{" +
               "code=" + code +
               ", msg='" + msg + '\'' +
               ", data=" + data +
               '}';
    }
}
