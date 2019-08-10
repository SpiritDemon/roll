package com.spiritdemon.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

public class RollInterceptor implements HandlerInterceptor {
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//异常信息记录
		if(ex != null) {
			Logger logger = Logger.getLogger(RollInterceptor.class);
			logger.error(ex.getMessage());
		}
	}
}
