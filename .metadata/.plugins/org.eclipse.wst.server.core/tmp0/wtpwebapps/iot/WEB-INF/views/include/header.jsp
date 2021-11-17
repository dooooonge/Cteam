<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	header ul, header ul li {
		margin: 0;
		padding : 0;
		display : inline;
	}
	
	header .category {
		font-size : 18px;
	}
	
	a { text-decoration: none; color : inherit; }
	
	header .category ul li:not(:first-child) {
		padding-left:30px;
	}
	
	header .category ul li a:hover, header .category ul li a.active {
		font-weight: bold;
		color : #0000cd;
	}
</style>

<header style="border-bottom : 1px solid #ccc; padding: 15px 0; text-align: left;">
<div class="category" style="margin-left:200px;">
	<ul>	<!-- c:url 을 통해 url 위치(/ 루트) 변경 -->
		<li><a href=" <c:url value='/' /> "> <img src="imgs/hanul_logo.png" /></a></li>
<%-- 	<li><a href="list.cu" ${category eq 'cu' ? "class='active'" : ''} >고객관리</a></li> --%>
		<li><a href="list.cu" class="${category eq 'cu' ? 'active' : ''}" >고객관리</a></li>
		<li><a href="list.hr" class="${category eq 'hr' ? 'active' : ''}" >사원목록</a></li>
		<li><a href="list.no" class="${category eq 'no' ? 'active' : ''}" >공지사항</a></li>
		<li><a href="list.bo" class="${category eq 'bo' ? 'active' : ''}" >방명록</a></li>
		<li><a href="list.da">공공데이터</a></li>
	</ul>
	<div style="position: absolute; right: 0; top: 20px; margin-right: 170px;">
		<ul>
			<!-- 로그인을 하지 않은 경우 -->
			<c:if test="${empty loginInfo }">
				<li>
					<a class='btn-fill' href="login">로그인</a>
					<a class='btn-fill' href="member">회원가입</a>
				</li>
			</c:if>
			<!-- 로그인을 한 경우 -->
			<c:if test="${!empty loginInfo }">
				<li style="padding-right: 10px;">${loginInfo.name }	님</li>
				<li><a class='btn-fill' href="logout">로그아웃</a></li>				
			</c:if>			
		</ul>
	</div>
</div>
</header>