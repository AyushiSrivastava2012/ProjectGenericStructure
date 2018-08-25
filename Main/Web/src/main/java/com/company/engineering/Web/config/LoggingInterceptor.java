package com.company.engineering.Web.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author B0096708
 *
 */
public class LoggingInterceptor implements HandlerInterceptor  {
	Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
	static final String APIMESSAGE=" Method: {}  API: {}  method name: '{}'";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("---Before Method Execution---");
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		logger.info(APIMESSAGE,
				request.getMethod(), request.getRequestURI(), handlerMethod.getMethod().getName());
		return true;

	}
	@Override
	public void postHandle(	HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		logger.info("---After Method Execution---");

		logger.info(APIMESSAGE,
				request.getMethod(), request.getRequestURI(), handlerMethod.getMethod().getName());
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
		logger.info("---Request Completed With Associated View---");
	}
} 