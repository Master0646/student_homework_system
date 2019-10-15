package com.tujietg.gradpro.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异常解析
 * 
 * Created by tujietg on Apr 2019.
 */
public class ExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		// 打印异常信息
		e.printStackTrace();
		String errorMessage;
		if (e instanceof LoginException) {
			errorMessage = ((LoginException) e).gasdaetErrorMessage();
		} else if (e instanceof FileException) {
			errorMessage = ((FileException) e).getErrorMessage();
		} else {
			errorMessage = new DefaultException(e.getMessage()).getErrorMessage();
		}
		request.setAttribute("errorMessage", errorMessage);
		try {
			// 转发到错误页面
			request.getRequestDispatcher("/jsp/error_500.jsp").forward(request, response);
		} catch (ServletException | IOException e1) {
			e1.printStackTrace();
		}
		return new ModelAndView();
	}
}
