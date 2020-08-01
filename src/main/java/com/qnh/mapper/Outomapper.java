package com.qnh.mapper;


import com.qnh.pojo.Devices;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Outomapper {
	
	@Select("select COUNT(*) from userinfo where device=#{devices}")
	public int countdevices(String devices);
	
	@Select("select sum(Socket_Error) from userinfo")
	public int sumsocket();
	
	@Select("select sum(Video_Error) from userinfo")
	public int sumvideo();
	
	@Select("select * from userinfo where Socket_Error>0 and DATE_SUB(CURDATE(), INTERVAL 3 DAY) <= date(date)")
	public List<Devices> listerorruser();
	
	@Select("select * from userinfo where Video_Error>0 and DATE_SUB(CURDATE(), INTERVAL 3 DAY) <= date(date)")
	public List<Devices> listerorrvideo();
	
	@Select("select sum(case when Video_error>0 then 1 else 0 END) as countNumber ,DATE_FORMAT(date,'%Y-%m-%d') AS dateTime FROM userinfo\n" + 
			"	where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(date) GROUP BY DATE_FORMAT(date,'%Y-%m-%d')")
	public List<Integer> sevenvideoerorr();
	
	@Select("select sum(case when Socket_Error>0 then 1 else 0 END) as countNumber ,DATE_FORMAT(date,'%Y-%m-%d') AS dateTime FROM userinfo\n" + 
			"	where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(date) GROUP BY DATE_FORMAT(date,'%Y-%m-%d')")
	public List<Integer> sevensocketerorr();
	
	@Select("SELECT sum(Carton) FROM `userinfo`;")
	public int sumCarton();

	@Select("select job_id as 任务ID,count(handle_code) as 执行失败次数,(select COUNT(handle_code) FROM XXL_JOB_QRTZ_TRIGGER_LOG WHERE" +
			" job_id = 任务ID AND trigger_time BETWEEN #{start} AND #{end}) as 执行总次数," +
			"(SELECT job_desc FROM `XXL_JOB_QRTZ_TRIGGER_INFO` WHERE id=任务ID)" +
			" as '任务描述'from XXL_JOB_QRTZ_TRIGGER_LOG where trigger_time between #{start} and #{end} " +
			"and handle_code = 500 GROUP BY job_id ORDER BY 执行失败次数 desc;")
	public List<Map<String ,Object>> triggers(String start, String end);
}
