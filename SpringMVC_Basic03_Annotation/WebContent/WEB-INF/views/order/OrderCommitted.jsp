<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>상품 목록(EL & JSTL 사용 출력)</h3>
   ${orderCommand} 안에 orderItem(ArrayList) 필요해요<br>
   <hr>
   <%-- <ul>
      <c:forEach items="${orderCommand.orderItem}" var="orderitem">
         <li>
            ${orderitem.itemid} - ${orderitem.number} - ${orderitem.remark}
         </li>
      </c:forEach>
   
   </ul> --%>
   <ul>
   	<c:forEach items="${orderCommand.orderItem}" var="orderitem">
   	<li>
            ${orderitem.itemid} - ${orderitem.number} - ${orderitem.remark}
         </li>
   	
   	</c:forEach>
   </ul>
</body>
</html>