<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bem-vindo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
    <div class="container">
		<div class="row">
			<h1 class="text-center">Tabela Verdade</h1>
			<div class="col-md-12">
				<form action="resultado.jsp" method="post">
					<div class="row" style="display:flex; justify-content:center; height: 30vh;">
						<h3 class="text-center">Insira sua expressão</h3>
						<div class="col-md-8">
							<input type="text" name="expression" class="form-control text-center" style="font-size:30px;" required>
						</div>
						<div class="col-md-8" style="display:flex; justify-content:center;">						
							<button class="btn btn-success">Avaliar Expressão</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>