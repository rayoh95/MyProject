package com.project.odw.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.project.odw.member.dto.MemberDto;
import com.project.odw.member.service.MemberService;

public class AutoLogin extends HandlerInterceptorAdapter{
	
	@Autowired
	private MemberService memberService;
	
	int i = 1;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		Cookie cook = WebUtils.getCookie(request, "loginCookie");

		if(cook != null) {

			MemberDto dto = memberService.getAutoLogin(cook.getValue());
			
			if(dto != null) {
				request.getSession().setAttribute("loginUser", dto.getMemberId());
			}
		}
		
		return true;
	}

}
