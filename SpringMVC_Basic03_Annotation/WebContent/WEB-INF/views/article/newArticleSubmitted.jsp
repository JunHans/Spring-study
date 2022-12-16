<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력값 확인하기</title>
</head>
<body>
			<%-- <h3>게시판 입력 내용 확인</h3>
			제목 : ${newArticleCommand.title}
			내용 : ${newArticleCommand.content}
			순번 : ${newArticleCommand.parentId} --%>
			
			<h3>게시판 입력 내용 확인</h3>
			제목 : ${Articledata.title}
			내용 : ${Articledata.content}
			순번 : ${Articledata.parentId}
</body>
</html>