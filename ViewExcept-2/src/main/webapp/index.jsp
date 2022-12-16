<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>3 TEAM_page</title>
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
<header class="w3-panel w3-center w3-opacity" style="padding:128px 16px">
    <h1 class="w3-xlarge">JH HJ YB BJ</h1>
  
  <h1>OUR TEAM</h1>
   <!--  <h1>Introduce</h1>
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
  </p></h1> -->
  
  <div class="w3-padding-32">
    <div class="w3-bar w3-border" ID="lang">
      <a href="auth/login?language=ko_kr" class="w3-bar-item w3-button">한국어</a>
      <a href="auth/login?language=en" class="w3-bar-item w3-button w3-light-grey">English</a>
      <a href="auth/login?language=ch" class="w3-bar-item w3-button">中国人</a>
      <!-- <a href="#" class="w3-bar-item w3-button w3-hide-small">일본어</a> -->
    </div>
    
      <div class="w3-bar w3-border" id="download">
      <a href="file/1" class="w3-bar-item w3-button">Photo</a>
      <a href="pagestat/rank" class="w3-bar-item w3-button w3-light-grey">Excell</a>
      <a href="pagestat/rankreport" class="w3-bar-item w3-button">PDF</a>
      </div>
  </div>
</header>

<!-- Photo Grid -->
 <div class="w3-panel w3-center w3-opacity" >
 		 <h1 class="w3-xlarge">OUR STORY</h1>
 </div>
<div class="w3-row-padding w3-grayscale" style="margin-bottom:128px">
  <div class="w3-half">
    <img src="images/yb.jpg" style="width:100%">
    <img src="images/loof.jpg" style="width:100%">
    <img src="images/bj.jpg" style="width:100%">
  </div>

  <div class="w3-half">
    <img src="images/window.jpg" style="width:100%">
  	 <img src="images/mapa.jpg" style="width:100%">
    <img src="images/DO_ThumbsUp.jpg" style="width:100%">
  </div>
</div>
  
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
