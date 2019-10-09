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
<script>
$(function(){
	$("#btn-category-add").click(function(){
		var categoryVo = {
				"categoryName" : $('input[name=categoryName]').val(),
				"categoryDesc" : $('input[name=categoryDesc]').val(),
				"userId" : $('input[name=userId]').val()
		};
		if(categoryVo == ''){
			alert("카테고리 항목을 모두 입력해주세요.");
			return;
		}
		
		// ajax 통신
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/api/blog/categoryinsert",
			contentType : "application/json; charset=utf-8",
			type: "post",
			dataType: "json",
			data: JSON.stringify(categoryVo),
			success: function(data){
				var jObj = JSON.parse(data);
				console.log(data);
				$(".category-tbody").append("<tr>" +
				        "<td>" + jObj.categoryNo + "</td>" +
				        "<td>" + jObj.categoryName + "</td>" +
				        "<td>" + jObj.categoryDesc + "</td>" +
				        "<td>" + jObj.categoryRegdate + "</td>" +
				        "<td>" +
				        "<img src='${pageContext.request.contextPath}/assets/images/delete.jpg'" +
				        "class='delete-img' value='"+ jObj.categoryNo + "'>" +
				        "</td>" +
				        "</tr>");
			},
			error: function(xhr, error){
				console.error("error : " + error);
			}
		});
		
	});
});
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.servletContext.contextPath}/blog/blog-admin-basic/${authUser.userId}">기본설정</a></li>
					<li class="selected">카테고리</li>
					<li><a href="${pageContext.servletContext.contextPath}/blog/blog-admin-write">글작성</a></li>
				</ul>
				
		      	<table class="admin-category">
		      		<thead>
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>설명</th>
		      			<th>날짜</th>
		      			<th>&nbsp;</th>      			
		      		</tr>
		      		</thead>
		      		
		      		<tbody class="category-tbody">
		      		<c:forEach items="${list}" var="vo" varStatus="status">
					<tr>
						<td>${vo.categoryNo}</td>
						<td>${vo.categoryName}</td>
						<td>${vo.categoryDesc}</td>
						<td>${vo.categoryRegdate}</td>
						<td>
							<img src="${pageContext.request.contextPath}/assets/images/delete.jpg" value="카테고리번호" class="delete-img">
						</td>
					</tr>
					</c:forEach> 
					</tbody>
							  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
      			<input type="hidden" name="userId" value="${authUser.userId}">
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" id="name-category-form" name="categoryName"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" id="contents-category-form" name="categoryDesc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input id="btn-category-add" type="button" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>