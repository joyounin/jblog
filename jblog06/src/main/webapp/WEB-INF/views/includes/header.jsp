<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<div id="header">
			<h1>${vo.title }</h1>
			<ul>
				<c:choose>
					<c:when test="${empty authUser }">
						<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
						<li><a href="${pageContext.request.contextPath}/${authUser.id}">블로그 홈</a></li>
					</c:when>
					<c:when test="${authUser.id eq vo.id }">
						<li style="color: white">${authUser.name }님 환영합니다.</li>
						<li><a href="${pageContext.request.contextPath}/${authUser.id }/admin/basic">블로그 관리</a></li>
						<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
						<li><a href="${pageContext.request.contextPath}/${authUser.id}">블로그 홈</a></li>
					</c:when>
					<c:otherwise>
							<li style="color: white">${authUser.name }님 환영합니다.</li>
						<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
						<li><a href="${pageContext.request.contextPath}/${authUser.id}">블로그 홈</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>