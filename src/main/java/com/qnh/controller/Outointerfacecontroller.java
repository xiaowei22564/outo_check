package com.qnh.controller;


import com.qnh.service.OutoserverImpl;
import com.qnh.unit.WorkBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="qnhtest")
public class Outointerfacecontroller {
	
	@Autowired
	private OutoserverImpl outoserver;

	@RequestMapping(value="triggers" ,produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Map<String, Object>> triggers(String start) {
		String star = start+" 00:00:00";
		String end = start+" 23:59:59";
		List<Map<String, Object>> triggers = outoserver.triggers(star, end);
		return triggers;
	}


	@RequestMapping(value="taskerror" ,produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String triggers(HttpServletRequest request,HttpServletResponse response,String start) {

		String star = start+" 00:00:00";
		String end = start+" 23:59:59";

		List<Map<String, Object>> triggers = outoserver.triggers(star, end);

		WorkBook.WriteExcel(triggers,response);
		return "执行完成";
	}
}
