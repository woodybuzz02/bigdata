<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Mouse 정보 삭제</h2>
	<form action="board" method="POST">
		<input type="hidden" name="command" value="delete">
		<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" value="${requestScope.mouse.id}"/></td>
				</tr>
		</table>
		<input type="submit" value="삭제">
	</form>
</body>
</html>