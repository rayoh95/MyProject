package com.project.odw.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberChk extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		
		if(!id.equals(session.getAttribute("loginUser"))) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String msg = "<script>"
						 + "alert('잘못된 정보입니다.');"
						 + "history.back();"
						 + "</script>";
			out.print(msg);
			return false;
		}
		
		return true;
	}
}
