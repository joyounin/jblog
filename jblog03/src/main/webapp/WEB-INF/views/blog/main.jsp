<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<c:forEach items="${postcontentslist }" var="vo" varStatus="status">
					<h4>${vo.title }</h4>
					<p>
						${vo.contents }
					<p>
					</c:forEach>

				</div>
				<ul class="blog-list">
					<c:forEach items="${posttitlelist }" var="vo" varStatus="status">
						<li><a href="${pageContext.request.contextPath}/jblog/${id}/${vo.categoryno}/${vo.no }">${vo.title }</a> <span>${vo.reg_date }</span></li>
					</c:forEach>
					
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${vo.profile }">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${list }" var="vo" varStatus="status">
					<li><a href="${pageContext.request.contextPath}/jblog/${id }/${vo.no }">${vo.categoryname }</a></li>
				</c:forEach>
			</ul>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>
</html>