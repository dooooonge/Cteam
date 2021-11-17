<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%-- <h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P> --%>

<%-- <jsp:include page="/WEB-INF/views/include/header.jsp" /> --%>
<!-- <div id="content"> -->
	<img src="imgs/banner.jpg" style="width: 80%" />
<!-- resources/images 폴더명을 imgs 로 매핑을 줌
     → webapp/WEB-INF/spring/appServlet/servle-context.xml 에서 매핑 -->	
<!-- </div> -->

<%-- <jsp:include page="/WEB-INF/views/include/footer.jsp" /> --%>

</body>
</html>
