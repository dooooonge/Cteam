<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table tr td {text-align: left;}
.addr input(:last-child) {margin-bottom: 5px;}
.addr input[name=addr] {width: calc(100% - 25px)}
.valid, .invalid { font-size : 13px; font-weight: bold; font-style: italic;}
.valid { color : #142850;}
.invalid { color: red; }
</style>
</head>
<body>
<h3>회원 정보</h3>
	<form action="detail"  method="post">
		<table class='w-pct40'>
			<tr>
				<th class='w-px120'>성명</th>
				<td >${vo.name }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${vo.email}</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${vo.nickname }</td>
			</tr>
			
			<tr>
				<th>주민등록번호</th>
				<td>${vo.idnumber }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${vo.address}</td>
			</tr>
		</table>
	</form>
	
	<div class='btnSet'>
		<a class='btn-fill' onclick = 'go_modify()'>정보 수정</a>
		<a class='btn-empty' href='<c:url value="/" />'>취소</a>		
	</div>
	
	<!-- 다음 주소 검색 API -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- DatePicker 사용하기 위한 js -->
  	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	
	<script type="text/javascript" src="js/join-check.js"></script> 
	<script type="text/javascript">
	
	function go_modify(){
		if(confirm("회원 정보를 수정하시겠습니까?")){
			location.href="pre_modify";
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	</script>

	
</body>
</html>