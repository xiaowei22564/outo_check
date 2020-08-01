package com.qnh.service;

import com.qnh.unit.LoadRunDemo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LoadRunserverlmpl {

    public List<List<Object>> read() throws IOException {
        List<List<Object>> read = LoadRunDemo.read();
        return read;
    }
}
