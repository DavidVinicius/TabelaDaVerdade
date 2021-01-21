<%@page import="truthTable.TruthTable"%>
<%@page import="analisys.PrecedenceAnalisys"%>
<%@page import="java.util.ArrayList"%>
<%@page import="analisys.SyntaxAnalisys"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	
	TruthTable truthTable = new TruthTable("A&B&B");	
	request.setAttribute("truthTable", truthTable);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado</title>
</head>
<body>
	<h1> Resultado da expressão: ${truthTable.getSentence() } </h1>
	
	<ul>
		<c:forEach items="${truthTable.getOperations()}" var="operation" varStatus="loop">		 	
			<li>
				<strong><c:out value="${loop.last ? 'Resultado referente ao passo ' : ('Passo nº: ' += loop.index) }"/></strong> - ${ operation } 		
			</li>									
		</c:forEach>
	</ul>
	
	<table>
		<thead>
			<tr>
				<c:forEach items="${truthTable.getColumns()}" var="column" varStatus="loop">		 	
					<th> ${ column }</th>									
				</c:forEach>
			</tr>
		</thead>
	</table>	

</body>
</html>