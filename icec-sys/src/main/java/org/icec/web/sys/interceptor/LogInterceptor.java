package org.icec.web.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.icec.web.sys.model.SysLog;
import org.icec.web.sys.utils.LogUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object arg2) throws Exception {
		/*
		SysLog log = null;
		    try {
		      log = LogUtils.getLog(httpServletRequest);
		    }catch (GeneralException g){
		      logger.warn("logger",g.getMessage());
		    }catch (Exception e){
		      logger.error("logger",e.getMessage());
		    }
		    httpServletRequest.setAttribute(LogUtils.LOG_OPERATE,log);
		  */
		    return true;
		  
	}

}
