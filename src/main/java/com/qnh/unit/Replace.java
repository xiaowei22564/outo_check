package com.qnh.unit;

import net.sf.json.JSONObject;

import java.io.*;

public class Replace {
    public static void main(String[] args) throws Exception {
        //GorGetToken();
        String s = DataToken("http://test.m-glory.net/third/login", "{\"code\":\"csbgcs\",\"pwd\":\"csbgcs123\",\"remember\":true,\"system\":\"bsp2-ng\"}");

    }

    public static void GorGetToken(String url, String params) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("D:\\request_0.gor"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\request.gor"), "UTF-8"));
        String contentline;
        String token = DataToken(url, params);
        try {

            while ((contentline = br.readLine()) != null) {
                if (contentline.contains("Authorization")) {
                    bw.write("Authorization: Bearer "+token);
                    bw.newLine();
                }else {
                    bw.write(contentline);
                    bw.newLine();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bw != null) {
                try {
                    //刷新缓存区
                    bw.flush();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String DataToken(String url, String params) throws Exception {
        String clientJson = Httpclient.ClientJson(url, params);
        JSONObject object = JSONObject.fromObject(clientJson);
        String data = object.getString("data");
        JSONObject token = JSONObject.fromObject(data);
        String token1 = token.getString("token");
        System.out.println("获取的token："+token1);
        return token1;
    }
}
