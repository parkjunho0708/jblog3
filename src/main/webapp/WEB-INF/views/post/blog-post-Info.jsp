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
      			<h4 class="n-c">포스트 정보</h4>
      			<form action="${pageContext.servletContext.contextPath}/${authUser.userId}/${postVo.postNo}/${postVo.categoryNo}/admin/post/delete" method="post">
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">포스트 제목</td>
		      			<td><input type="text" id="name-category-form" name="categoryName" value="${postVo.postTitle}" readonly="readonly"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">포스트 작성일</td>
		      			<td><input type="text" id="name-category-form" name="categoryRegdate" value="${postVo.postCreatedate}" readonly="readonly"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">포스트 설명</td> 
		      			<td><textarea rows="5" cols="70" readonly="readonly">${postVo.postContents}</textarea></td>
		      		</tr>
		      		<c:if test="${authUser.userId eq postVo.userId}">
		      		<tr>
			      			<td>&nbsp;</td>
			      			<td class="s"><input type="submit" value="삭제하기"></td>
			      	</tr>
			      	</c:if>      		      		
		      	</table>
		      	</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>