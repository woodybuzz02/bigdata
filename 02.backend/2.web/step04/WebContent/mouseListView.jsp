<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
 	a {
 		color : black;
 		text-decoration:none;
 		font-weight : bold; 
 	}
 	a.logo {
 		font-size : 30px;
 	}
 	
</style>



<body>
	<table>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>국적</th>
			<th>주소</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty requestScope.list || fn:length(list) == 0}">
				<tr>
					<td colspan="5">
						<p>등록된 mouse 정보가 없습니다.</p>
					</td>
				</tr>
			</c:when>	
			<c:otherwise>	
				<c:forEach items="${requestScope.list}" var="m">
					<tr>
						<th><a href="board?command=read&id=${m.id}">${m.id}</a></th>
						<th>${m.name}</th>
						<th>${m.country}</th>
						<th>${m.address}</th>
					</tr>
				</c:forEach>
			</c:otherwise>	
		</c:choose>
	</table>
	<a href = "<%=request.getContextPath()%>/mouseInsert.jsp">mouse 등록</a>
</body>
</html>