package com.qnh.controller;

import com.qnh.service.LoadRunserverlmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="load")
public class LoadRunController {

    @Autowired
    private LoadRunserverlmpl loadRun;

    @RequestMapping(value="read" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String memoryread() throws IOException {
        List<List<Object>> read = loadRun.read();
        return read.toString();
    }
}
