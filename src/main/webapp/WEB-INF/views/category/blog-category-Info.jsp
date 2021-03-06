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
<script src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js" type="text/javascript"></script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.servletContext.contextPath}/${authUser.userId}/admin/basic">기본설정</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/${authUser.userId}/admin/category">카테고리</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/${authUser.userId}/admin/write">글작성</a></li>
				</ul>
      			<h4 class="n-c">카테고리 정보</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" id="name-category-form" name="categoryName" value="${categoryVo.categoryName}" readonly="readonly"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">카테고리 작성일</td>
		      			<td><input type="text" id="name-category-form" name="categoryRegdate" value="${categoryVo.categoryRegdate}" readonly="readonly"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">카테고리 설명</td>
		      			<td><textarea rows="5" cols="70" readonly="readonly">${categoryVo.categoryDesc}</textarea></td>
		      		</tr>      		      		
		      	</table>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>