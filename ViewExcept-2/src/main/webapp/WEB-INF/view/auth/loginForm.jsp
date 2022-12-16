<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<%-- <html>
<head>
<title><spring:message code="login.form.title" /></title>
</head>
<body>

	<form:form commandName="loginCommand">
		<form:hidden path="securityLevel" />
		<form:errors element="div" />
			<p>
				<spring:message code="email"></spring:message>
				<br>
				<spring:message code="password"></spring:message>
				<br>
				<spring:message code="login.form.type"></spring:message>
				<br>
				<spring:message code="login.form.login"></spring:message>
				<br>
				<spring:message code="login.form.help" />
			</p>
	</form:form>


</body>
</html> --%>
<%@ page contentType="text/html; charset=utf-8" %>
<!-- <html>
<body>
<ul>

<li><h3>커스텀 뷰:</h3>
	<ul>
	파일 아이디가 1일 때 ->> 다운로드컨트롤러로 가서 정해주는 파일 다운로드 시킴
	<li><a href="file/1">/file/1</a>: 파일 다운로드 <small>DownloadView, DownloadController.download()</small></li><hr>
	<li><a href="pagestat/rank">/pagestat/rank</a>: 엑셀 다운로드 <small>PageRankView, PageRankStatController.pageRank()</small></li><hr>
	<li><a href="pagestat/rankreport">/pagestat/rankreport</a>: PDF 다운로드 <small>PageReportView, PageRankStatController.pageRankReport()</small></li>
	</ul>
</li>
 <li>로케일 변경:
	<ul>
	<li><a href="changeLanguage?language=en">전체 언어 to English</a>: LocaleResolver 예, LocaleChangeController.change(), lang 파라미터로 변경</li>
	<li><a href="auth/login?language=en">English</a>: LocaleChangeInterceptor 예, lang으로 변경 후, lang 없이 확인</li>
	<li><a href="auth/login?language=ko_kr">한국어</a></li>
	</ul>
</li>
</ul>

</body>
</html> -->
<html>
<head>
<title><spring:message code="login.form.title" /></title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1 {font-family: "Raleway", Arial, sans-serif}
h1 {letter-spacing: 6px}
.w3-row-padding img {margin-bottom: 12px}

#download{
	margin-left: 10px;
}
#lang{
	margin-right: 10px;
}
</style>
</head>
<body>

<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width:1500px">

<!-- Header -->

<header class="w3-panel w3-center w3-opacity" style="padding:128px 16px; background-color:#F1F1F1;">
    <h1>Introduce</h1>
    <h1 class="w3-xlarge"><p> 
    <spring:message code="email"></spring:message>
    <br>
    <spring:message code="password"></spring:message>
    <br>
    <spring:message code="login.form.type"></spring:message>
    <br>
    <spring:message code="login.form.login"></spring:message>
    <br>
    <spring:message code="login.form.help" />
  </p></h1>
</header>
<!-- End Page Content -->
</div>

<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-light-grey w3-center w3-large"> 
  <i class="fa fa-facebook-official w3-hover-opacity"></i>
  <i class="fa fa-instagram w3-hover-opacity"></i>
  <i class="fa fa-snapchat w3-hover-opacity"></i>
  <i class="fa fa-pinterest-p w3-hover-opacity"></i>
  <i class="fa fa-twitter w3-hover-opacity"></i>
  <i class="fa fa-linkedin w3-hover-opacity"></i>
  <p>Created by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank" class="w3-hover-text-green">3 Team</a></p>
</footer>

</body>
</html>
