package com.qnh.controller;

import com.qnh.pojo.Greeting;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(value="/test")
    @ResponseBody
    public String test(@RequestBody(required = false) JSONObject jsonObject) {
        JSONObject restful = new JSONObject();
        restful.put("msg","ok");
        restful.put("data",jsonObject);
        return restful.toString();
    }
}
