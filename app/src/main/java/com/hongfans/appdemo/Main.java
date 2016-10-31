package com.hongfans.appdemo;

import com.google.gson.Gson;
import com.hongfans.appdemo.bean.Coupon;
import com.hongfans.appdemo.bean.Response;
import com.hongfans.appdemo.bean.Response4List;
import com.hongfans.appdemo.bean.VersionInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */
public class Main {

    public static void main(String[] args) {

        String json1 = genJSON();
        Response<VersionInfo> r1 = Response.fromJson(json1, VersionInfo.class);
        println(json1);
        println(r1);
        println(r1.data.name);

        println("--------------------------");

        String json2 = genJSON2();
        Response4List<Coupon> r2 = Response4List.fromJson(json2, Coupon.class);
        println(json2);
        println(r2);
        println(r2.data.get(0).data);
    }

    private static String genJSON() {
        Response<VersionInfo> response = new Response<>();
        response.code = 0;
        response.msg = "success";
        response.data = new VersionInfo();
        response.data.code = 2001;
        response.data.name = "2.0.0.1";

//        return Response.toJson(response, VersionInfo.class);
        return new Gson().toJson(response);
    }

    private static String genJSON2() {
        Response<List<Coupon>> response = new Response<>();
        response.code = 0;
        response.msg = "success";
        List<Coupon> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Coupon coupon = new Coupon();
            coupon.data = "data " + 10 + i;
            coupon.name = "coupon " + 10 + i;
            list.add(coupon);
        }
        response.data = list;

        return new Gson().toJson(response);
    }

    private static void println(Object obj) {
        println(obj.toString());
    }

    private static void println(String json) {
        System.out.println("println: " + json);
    }
}
