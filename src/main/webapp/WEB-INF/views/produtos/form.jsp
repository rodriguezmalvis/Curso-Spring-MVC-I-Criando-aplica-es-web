<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Casa do Código</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">Casa do Codigo</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="${s:mvcUrl('PC#listar').build() }">Lista de produtos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${s:mvcUrl('PC#form').build() }">Cadastro de produtos</a>
	      </li>
	    </ul>
	  </div>
	</nav>

	<div class="container">
	
	<h1>Cadastro de Produto</h1>
	
		<form:form action="${s:mvcUrl('PC#grava').build() }" method="post" commandName="produto" enctype="multipart/form-data">
		<div class="form-group">
			<label>Titulo</label>
			<form:input path="titulo" cssClass="form-control"/>
			<form:errors path="titulo"></form:errors>
		</div>
		<div class="form-group">
			<label>Descriçao</label>
			<form:textarea rows="10" cols="20" path="descricao" cssClass="form-control"/>
			<form:errors path="descricao"></form:errors>
		</div>
		<div class="form-group">
			<label>Páginas</label>
			<form:input path="paginas" cssClass="form-control"/>
			<form:errors path="paginas"></form:errors>
		</div>
		<div class="form-group">
			<label>Data de Lançamento</label>
			<form:input path="dataLancamento" cssClass="form-control"/>
			<form:errors path="dataLancamento"></form:errors>
		</div>
		<c:forEach items="${tipos }" var="tipopreco" varStatus="status">
			<label>${tipopreco }</label>
			<form:input path="precos[${status.index }].valor" cssClass="form-control"/>
			<form:hidden path="precos[${status.index }].tipo" name="precos[${status.index }].tipo" value="${tipopreco }"/>
			<br>
		</c:forEach>
		<div class="form-group">
			<label>Sumário</label>
			<input name="sumario" type="file" class="form-control">
		</div>
		<button type="submit" class="btn btn-primary">Cadastrar</button>
	</form:form>
	
	</div>

</body>
</html>