package com.douzone.jblog.security;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import com.douzone.jblog.vo.UserVo;

public class AuthInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. handler 종류 확인 
		if(!(handler instanceof HandlerMethod)) {
			//DefaultServletHandler가 처리하는 경우(정적 자원, /assets/** < 이렇게 들어온다)
			return true;
		}
		
		// 2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		// 3. Handler Method의 @Auth 가져오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		// 4. Handler Method에 @Auth 가 없으면 Type(Class)에 붙어 있는 지 확인한다.
		Auth adminRole = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
		
		if(auth == null) {
			auth = adminRole;
		} 
		// 5. Type이나 Method에 @Auth가 없는 경우
		if(auth == null) {
			return true;
		}
		UserVo vo = (UserVo) request.getSession().getAttribute("authUser");
		Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		String userId = (String)pathVariables.get("userId");

		if(vo == null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
		if(userId.equals(vo.getId())) {
			return true;
		}

		// 8. 인증 확인
		response.sendRedirect(request.getContextPath());
		return false;
	}
	
}
