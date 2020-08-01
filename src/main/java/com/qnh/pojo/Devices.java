package com.qnh.pojo;

public class Devices {

	private int id;
	private int channel;
	private int appuid;
	private int lessonid;
	private String app_edition;
	private String device;
	private String system;
	private String uid;
	private int date;
	private int Socket_Error;
	private int Video_Error;
	private int Courseware_Error;
	private int Carton;
	private String route;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getAppuid() {
		return appuid;
	}
	public void setAppuid(int appuid) {
		this.appuid = appuid;
	}
	public int getLessonid() {
		return lessonid;
	}
	public void setLessonid(int lessonid) {
		this.lessonid = lessonid;
	}
	public String getApp_edition() {
		return app_edition;
	}
	public void setApp_edition(String app_edition) {
		this.app_edition = app_edition;
	}
	public String getDevices() {
		return device;
	}
	public void setDevices(String devices) {
		this.device = devices;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getSocket_Error() {
		return Socket_Error;
	}
	public void setSocket_Error(int socket_Error) {
		Socket_Error = socket_Error;
	}
	public int getVideo_Error() {
		return Video_Error;
	}
	public void setVideo_Error(int video_Error) {
		Video_Error = video_Error;
	}
	public int getCourseware_Error() {
		return Courseware_Error;
	}
	public void setCourseware_Error(int courseware_Error) {
		Courseware_Error = courseware_Error;
	}
	public int getCarton() {
		return Carton;
	}
	public void setCarton(int carton) {
		Carton = carton;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "Devices [id=" + id + ", channel=" + channel + ", appuid=" + appuid + ", lessonid=" + lessonid
				+ ", app_edition=" + app_edition + ", device=" + device + ", system=" + system + ", uid=" + uid
				+ ", date=" + date + ", Socket_Error=" + Socket_Error + ", Video_Error=" + Video_Error
				+ ", Courseware_Error=" + Courseware_Error + ", Carton=" + Carton + ", route=" + route + "]";
	}
	
}
