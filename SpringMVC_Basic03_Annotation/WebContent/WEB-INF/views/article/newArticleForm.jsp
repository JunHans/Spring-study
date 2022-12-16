<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 화면</title>
</head>
<body>
		<h3>게시판 글쓰기 입력 Form</h3>
		<h4>Form태그에 액션 주소가 없으면 현재 주소창 URL이 액션 주소</h4>
		<form method="post">  <!-- Form태그에 액션 주소가 없으면 현재 주소창 URL이 액션 주소  -->
				<input type="hidden" name="parentId" value="0">
				제목 : <input type="text" name="title"><br>
				내용 : <input type="text" name="content"><br>
				<input type="submit">
		</form>
</body>
</html>