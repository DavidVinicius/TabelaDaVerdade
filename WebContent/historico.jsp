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
	<ul>
		<c:forEach items="${ historico }" var="hist">
			<li>${ hist.expression}				
					
			</li>
		</c:forEach>
	</ul>
	
	<a href="${linkEntrada }">
		<button>Voltar</button>
	</a>
	<footer>
			<div class="main">
				<div class="content footer-instituto">
				<ul>
					<li><h4>Instituto Federal de São Paulo</h4></li>
					<li><h6>Avenida Thereza Ana Cecon Breda, s/n - Vila São Pedro</h6></li>
					<li><h6>Hortolândia-SP - Brasil - Cep: 13183-250</h6></li>
					<li><h6>Telefone: (19) 3865-8070</h6></li>
					<li><h6>Site oficial: hto.ifsp.edu.br</h6></li>
				</ul>
				</div>
			</div>
			<div class="last">Desenvolvimento WEB II - 6º Semestre / Análise e Desenvolvimento de Sistemas</div>
		</footer>
</body>
</html>