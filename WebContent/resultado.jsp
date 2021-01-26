<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="truthTable.TruthTable"%>
<%@page import="analisys.PrecedenceAnalisys"%>
<%@page import="java.util.ArrayList"%>
<%@page import="analisys.SyntaxAnalisys"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	
	String expression = request.getParameter("expression");
	TruthTable truthTable = new TruthTable(expression);	
	request.setAttribute("truthTable", truthTable);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			
			<h1 class="text-center"> Resultado da expressão: ${truthTable.getSentence() } </h1>
			<div class="col-md-12">
				<p>Para resolver a tabela, siga esses passos</p>
				<ul>
					<c:forEach items="${truthTable.getOperations()}" var="operation" varStatus="loop">		 	
						<li>
							<strong><c:out value="${loop.last ? 'Resultado referente ao passo ' : ('Passo nº: ' += loop.index) }"/></strong> - ${ operation } 		
						</li>									
					</c:forEach>
				</ul>
				
				<table class="table table-dark table-striped">
					<thead>
						<tr class="text-center">
							<c:forEach items="${truthTable.getColumns()}" var="column" varStatus="loop">		 	
								<th> ${ column }</th>									
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<c:forEach begin="0" end="${ truthTable.getNumberOfRows() - 1 }" varStatus="loop">
							<tr>
								<c:forEach begin="0" end="${ truthTable.getNumberOfVariables() - 1 }" varStatus="loopVar">
									<td class="text-center"> ${ truthTable.getTableValue(loop.index, loopVar.index) }</td>
								</c:forEach>
								<c:forEach begin="0" end="${ truthTable.getNumberOfOperations() - 1 }" varStatus="loop">
									<td><input type="text" class="form-control" style="max-width: 75px;margin: 0 auto;"></td>
								</c:forEach>
							</tr>		 																
						</c:forEach>						
					</tbody>
				</table>
			</div>			
		</div>		
		<div class="row">
			<div class="col-md-12">
				<a href="index.jsp">
					<button class="btn btn-primary">Avaliar outra expressão</button>
				</a>
			</div>
		</div>
	</div>
		

</body>
</html>