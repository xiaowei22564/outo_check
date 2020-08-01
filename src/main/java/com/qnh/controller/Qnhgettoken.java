package com.qnh.controller;

import com.qnh.service.GetTokenlmpl;
import com.qnh.unit.Replace;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Qnhgettoken {

    @Autowired
    private GetTokenlmpl getToken;

    @RequestMapping(value="/gettoken")
    @ResponseBody
    public String GetToken(@RequestBody JSONObject jsonObject) throws Exception {
        String url = jsonObject.getString("url");
        String params = jsonObject.getString("Params");
        Replace.GorGetToken(url,params);
        return "执行完成！";
    }
}
