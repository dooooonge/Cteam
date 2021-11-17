<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#popup { width: 450px; height: 450px; border: 2px solid #777; display: none; }
	.popup { width: 100%; height: 100%;}
	.comment { margin : 0 auto; padding-top: 20px; width: 500px; }
	#comment_regist {width: 100%}
	#comment_regist span {width: 50%; float: left;}
	
	textarea#comment {width: 96%; height: 60px; margin-top: 5px; resize: none;}
</style>


</head>
<body>
<h3>방명록 안내</h3>
<table>
	<tr>
		<th class='w-px120'>제목</th>
		<td colspan="5" class='left'>${vo.title }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${vo.name }</td>
		<th class='w-px120'>작성일자</th>
		<td class='w-px120'>${vo.writedate }</td>
		<th class='w-px80'>조회수</th>
		<td class='w-px80'>${vo.readcnt }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="5" class="left"> ${fn:replace(vo.content, crlf, '<br>')}</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td colspan="5" class="left">${vo.filename }
			<c:if test="${! empty vo.filename }">
				<a id = 'preview'></a>
				<a href='download.bo?id=${vo.id }'><i class="fas fa-download font-img"></i></a>		
			</c:if>
		</td>
	</tr>
</table>

<div class='btnSet'>
	<a class='btn-fill' onclick='$("form").submit()'>목록으로</a>
	<c:if test="${loginInfo.id eq vo.writer }">		
		<a class='btn-fill' onclick= '$("form").attr("action", "modify.bo"); 
		$("form").submit()' >수정</a>
		<a class='btn-fill' onclick="if (confirm ('정말 삭제?') )
		 { href='delete.bo?id=${vo.id }'  } ">삭제</a>
	</c:if>
</div>
<!-- 댓글 입력 처리 부분 -->
<div class='comment'>
	<div id = 'comment_regist'> 
		<span class='left'><strong>댓글작성</strong></span>
		<span class='right'><a class='btn-fill-s' onclick="comment_regist()">댓글등록</a></span>
		<textarea id='comment'></textarea>	
	</div>
	<div id="comment_list"></div>
</div>



<!-- 목록 요청에 필요한 데이터를 post 방식으로 전달하는 방법 -->
<form method="post" action="list.bo">
	<input type="hidden" name='id' value="${vo.id }">					<!-- 글 id -->
	<input type="hidden" name='search' value ='${page.search }' /> 		<!-- 검색조건 -->
	<input type="hidden" name='keyword' value ='${page.keyword }' />	<!-- 검색어 -->
	<input type="hidden" name='curPage' value ='${page.curPage }' />	<!-- 현재 페이지 -->
	<input type="hidden" name='viewType' value ='${page.viewType }' />	<!-- 게시판 형태 -->
	<input type="hidden" name='pageList' value ='${page.pageList }' />	<!-- 페이지당 보여질 목록수 -->
</form>

<!-- 이미지를 크게 볼 수 있도록 처리 (popup 형태) -->
<div id='popup-background'></div>
<div id='popup' class='center'></div>

<script type="text/javascript" src='js/file_check.js'></script>

<script type="text/javascript">
	
	function comment_regist() {
		if(${ empty loginInfo}){
			alert("로그인해주세요");
			return;
		}else if( $('#comment').val().trim()==''){
		//}else if( $.trim($('#comment').val())==''){
			alert("댓글을 입력한 후에 등록해주세요");
			$('#comment').val('');
			$('#comment').focus();
			return;
		}
		
		$.ajax({
			/*경로형태로 url 지정()  */
			url: "board/comment/regist",
			data: {pid:${vo.id}, content: $('#comment').val() },
			success: function (response) {
				if(response){//url의 결과값은 response로 받는다.
				alert("댓글이 등록되었습니다!");
				$('#comment').val('');
					comment_list();
				}else{
				alert("댓글 등록에 실패했습니다.");					
				}
			},
			error: function(req, text) {
				alert(text + ":"+req.status);
			}
			
		});
	}
	
	function comment_list() {
		$.ajax({
			url:"board/comment/list/${vo.id}"
			//,data: pid: ${vo.id}
			,success: function(response) {
				$('#comment_list').html(response);
			}
			,error: function() {
				alert(text+":"+req.status);
			}	
		})
	}

</script>

<script type="text/javascript">
	//맨 마지막에 실행되는 js
	$(function () {
		// 첨부된 파일이 이미지 파일인 경우 미리보기 되게끔..
		if ( ${ ! empty vo.filename} ) { // 첨부 파일이 있다면
			if ( isImage ( '${vo.filename}' )) { // 이미지 파일이면
				$('#preview').html('<img src="${vo.filepath}" id="preview-img" />' );
			}
		}
		comment_list();
	})

	$(document).on('click', '#preview-img', function () {
		$('#popup, #popup-background').css('display', 'block');
		$('#popup').html('<img src="${vo.filepath}" class="popup" /> ');
	}).on('click', '#popup-background', function () {
		$('#popup, #popup-background').css('display', 'none');
	})
	

</script>

</body>
</html>









