<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bem-vindo</title>
</head>
<body>
    <div class="container">
		<div class="row">
			<h1 class="text-center">Tabela Verdade</h1>
			<div class="col-md-12">
				<form action="resultado.jsp" method="post">
					<table class="table table-dark table-striped">
						<thead>
							<tr class="text-center">
								<h4>Insira suas comparações:</h4>
							</tr>
						</thead>
						<tbody>
							<tr class="text-center">
							<td>
								<label for="pexpressao">Primeira Expressão:</label> 
								<input type="text" id="pvalor" pattern="[A-Z]" placeholder="Insira uma letra maiúscula">
							</td>
							<td>
								<label for="tipo">Tipo de comparação:</label> 
								<input list="operadores" id="poperador">
								<datalist id="operadores">
									<option value="&">
									<option value="|">
									<option value="!">
								</datalist>
							</td>
							<td>
								<label for="sexpressao">Segunda Expressão:</label> 
								<input type="text" id="svalor" pattern="[A-Z]" placeholder="Insira uma letra maiúscula">
							</td>
							<td>
							<td>
								<label for="tipo">Tipo de comparação:</label> 
								<input list="operadores" id="soperador">
								<datalist id="operadores">
									<option value="&">
									<option value="|">
									<option value="!">
								</datalist>
							</td>
							<td>
								<label for="texpressao">Terceira Expressão:</label> 
								<input type="text" id="tvalor" pattern="[A-Z]" placeholder="Insira uma letra maiúscula">
							</td>
							<td>
								<input type="submit" value="Enviar">
							</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>