<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/index.jsp" var="linkEntrada" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historico</title>
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	
	<jsp:include page="includes/header.jsp" />
	
	<section class="historico" id="historico" style="height: 50vh">
		<div class="content">
			<ul>
				<c:forEach items="${ historico }" var="hist">
					<li> <h3> ${ hist.expression} </h3>				
							
					</li>
				</c:forEach>
			</ul>
			
			<a href="${linkEntrada }">
				<button>Voltar</button>
			</a>
			
		</div>
	</section>
		
	
	<jsp:include page="includes/footer.jsp" />	
</body>
</html>