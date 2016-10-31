package com.hongfans.appdemo.bean;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */
public class Response4List<T> {

    public int     code;
    public String  msg;
    public List<T> data;

    public static <T> Response4List<T> fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(Response4List.class, clazz);
        return gson.fromJson(json, objectType);
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
