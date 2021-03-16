<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntrada" />
<c:url value="/historico" var="linkHistorico" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabela Verdade</title>
<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet">
</head>
<body>
	<header>
		<div class="content">
			<nav>
				<p class="brand">
					Tabela<strong> Verdade</strong>
				</p>
				<ul>
					<li><a href="#david">David</a></li>
					<li><a href="#juan">Juan</a></li>
				</ul>
				<img alt="logo" src="imagens/logo1.png">
			</nav>
			<div class="header-block">
				<div class="text">
					<form action="/TabelaDaVerdadeWeb/entrada" method="post">
						<h2>Insira sua expressão</h2>
						<div>
							<input type="text" name="expression" placeholder="Exemplo: A|B"
								required>
						</div>
						<nav>
							<button class="button">Avaliar Expressão</button>
							<a href="/TabelaDaVerdadeWeb/historico">
								<button type="button">Histórico</button>
							</a>
						</nav>
					</form>
				</div>
			</div>
		</div>
	</header>
	<section class="david" id="david">
		<div class="content">
			<div class="david-titulo">
				<h3>David</h3>
			</div>
			<div class="david-info">
				<ul>
					<li>Autor: <strong> David Vinicius da Silva</strong></li>
					<li>E-mail: <strong> david.vinicius@aluno.ifsp.edu.br</strong></li>
					<li>Matrícula: <strong> HT3000052</strong></li>
				</ul>
			</div>
		</div>
	</section>
	<section class="juan" id="juan">
		<div class="content">
			<div class="juan-titulo">
				<h3>Juan</h3>
			</div>
			<div class="juan-info">
				<ul>
					<li>Autor: <strong>Juan Felipe Cavalari Bailke</strong></li>
					<li>E-mail: <strong>juan.bailke@aluno.ifsp.edu.br</strong></li>
					<li>Matrícula: <strong>HT3000796</strong></li>
				</ul>
			</div>
		</div>
	</section>
	<footer>
		<div class="main">
			<div class="content footer-instituto">
				<ul>
					<li><h4>Instituto Federal de São Paulo</h4></li>
					<li><h6>Avenida Thereza Ana Cecon Breda, s/n - Vila São
							Pedro</h6></li>
					<li><h6>Hortolândia-SP - Brasil - Cep: 13183-250</h6></li>
					<li><h6>Telefone: (19) 3865-8070</h6></li>
					<li><h6>Site oficial: hto.ifsp.edu.br</h6></li>
				</ul>
			</div>
		</div>
		<div class="last">Desenvolvimento WEB II - 6º Semestre / Análise
			e Desenvolvimento de Sistemas</div>
	</footer>

</body>

</html>