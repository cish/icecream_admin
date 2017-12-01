package org.icec.web.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.icec.web.core.log.LogManager;
import org.icec.web.core.log.LogTaskFactory;
import org.icec.web.sys.model.SysLog;
import org.icec.web.sys.utils.ShiroKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志记录
 *
 * 
 */
@Aspect
@Component
public class WebLogAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(public * org.icec.web.*.controller.*.*(..))")
	public void cutService() {
	}

	@Around("cutService()")
	public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
		// 接收到请求，记录请求内容
		// 先执行业务
		Long start = System.currentTimeMillis();
		Object result = point.proceed();
		try {
			handle(point, start);
		} catch (Exception e) {
			logger.error("日志记录出错!", e);
		}

		return result;
	}

	private void handle(ProceedingJoinPoint point, Long start) throws Exception {
		logger.info("WebLogAspect.handle()");
		Long end = System.currentTimeMillis();
		SysLog sysLog = new SysLog();
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String requestUrl=request.getServletPath();
		sysLog.setRequestUri(requestUrl);
		sysLog.setMethod(request.getMethod());
		sysLog.setRemoteAddr(request.getRemoteAddr());
		sysLog.setUserAgent(request.getHeader("user-agent"));
		
		//登录的时候，不记录账号密码
		if(requestUrl.contains("sys/login")||requestUrl.contains("sys/logout")) {
			sysLog.setType(SysLog.LOGTYPE_LOGIN);//登录请求
		}else {
			sysLog.setType(SysLog.LOGTYPE_REQUEST);//业务请求
			Map<String, Object> param = new HashMap<String, Object>();
			Enumeration<String> enu = request.getParameterNames();
			while (enu.hasMoreElements()) {
				String paraName = (String) enu.nextElement();
				param.put(paraName, request.getParameter(paraName));
			}
			ObjectMapper mapper = new ObjectMapper();
			String params = mapper.writeValueAsString(param);
			sysLog.setParams(params);
		}
		
		
		sysLog.setLoseTime(end-start);
		
		if(ShiroKit.isUser()) {
			sysLog.setCreateBy(ShiroKit.getUser().getLoginName());
		}else {
			sysLog.setCreateBy("");
		}
		if(logger.isDebugEnabled()) {
			logger.debug("请求日志："+sysLog.toString());
		}
		LogManager.me().executeLog(LogTaskFactory.requestLog(sysLog));
	}
}