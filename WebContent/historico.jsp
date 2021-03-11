<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/index.jsp" var="linkEntrada" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:forEach items="${ historico }" var="hist">
			<li>${ hist.expression}				
					
			</li>
		</c:forEach>
	</ul>
	
	<a href="${linkEntrada }">
		<button class="btn btn-info">Voltar</button>
	</a>	
</body>
</html>