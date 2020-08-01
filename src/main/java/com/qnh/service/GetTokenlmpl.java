package com.qnh.service;

import com.qnh.controller.Qnhgettoken;
import com.qnh.unit.Httpclient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GetTokenlmpl {
    @Resource
    private Qnhgettoken qnhgettoken;

    public String gettoken(String url,String params) throws Exception {

        String token = Httpclient.ClientJson(url, params);
        return token;
    }
}
