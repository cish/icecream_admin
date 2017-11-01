package org.icec.web.sys.model;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2017-11-01
*/
public class SysLog   implements Serializable{
	//编号
	private Integer id ;
	//创建者
	private String createBy ;
	//异常信息
	private byte[] exception ;
	//操作方式
	private String method ;
	//操作提交的数据
	private byte[] params ;
	//操作IP地址
	private String remoteAddr ;
	//请求URI
	private String requestUri ;
	//日志标题
	private String title ;
	//日志类型
	private String type ;
	//用户代理
	private String userAgent ;
	//创建时间
	private Date createDate ;
	
	public SysLog() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	public String getCreateBy(){
		return  createBy;
	}
	public void setCreateBy(String createBy ){
		this.createBy = createBy;
	}
	
	public byte[] getException(){
		return  exception;
	}
	public void setException(byte[] exception ){
		this.exception = exception;
	}
	
	public String getMethod(){
		return  method;
	}
	public void setMethod(String method ){
		this.method = method;
	}
	
	public byte[] getParams(){
		return  params;
	}
	public void setParams(byte[] params ){
		this.params = params;
	}
	
	public String getRemoteAddr(){
		return  remoteAddr;
	}
	public void setRemoteAddr(String remoteAddr ){
		this.remoteAddr = remoteAddr;
	}
	
	public String getRequestUri(){
		return  requestUri;
	}
	public void setRequestUri(String requestUri ){
		this.requestUri = requestUri;
	}
	
	public String getTitle(){
		return  title;
	}
	public void setTitle(String title ){
		this.title = title;
	}
	
	public String getType(){
		return  type;
	}
	public void setType(String type ){
		this.type = type;
	}
	
	public String getUserAgent(){
		return  userAgent;
	}
	public void setUserAgent(String userAgent ){
		this.userAgent = userAgent;
	}
	
	public Date getCreateDate(){
		return  createDate;
	}
	public void setCreateDate(Date createDate ){
		this.createDate = createDate;
	}
	
	
	

}
