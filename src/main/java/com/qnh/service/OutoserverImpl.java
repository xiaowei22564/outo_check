package com.qnh.service;


import com.qnh.mapper.Outomapper;
import com.qnh.pojo.Devices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OutoserverImpl{

	@Resource
	private Outomapper outomapper;

	public List<Map<String, Object>> triggers(String start,String end){
		List<Map<String, Object>> triggers = outomapper.triggers(start, end);
		return triggers;
	}
}
