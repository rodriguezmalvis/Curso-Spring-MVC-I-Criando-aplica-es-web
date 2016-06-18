<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Casa do Código</title>
</head>
<body>

	<form:form action="${s:mvcUrl('PC#grava').build() }" method="post" commandName="produto" enctype="multipart/form-data">
		<div>
			<label>Titulo</label>
			<form:input path="titulo"/>
			<form:errors path="titulo"></form:errors>
		</div>
		<div>
			<label>Descriçao</label>
			<form:textarea rows="10" cols="20" path="descricao"/>
			<form:errors path="descricao"></form:errors>
		</div>
		<div>
			<label>Páginas</label>
			<form:input path="paginas"/>
			<form:errors path="paginas"></form:errors>
		</div>
		<div>
			<label>Data de Lançamento</label>
			<form:input path="dataLancamento"/>
			<form:errors path="dataLancamento"></form:errors>
		</div>
		<c:forEach items="${tipos }" var="tipopreco" varStatus="status">
			<label>${tipopreco }</label>
			<form:input path="precos[${status.index }].valor"/>
			<form:hidden path="precos[${status.index }].tipo" name="precos[${status.index }].tipo" value="${tipopreco }"/>
			<br>
		</c:forEach>
		<div>
			<label>Sumário</label>
			<input name="sumario" type="file">
		</div>
		<button type="submit">Cadastrar</button>
	</form:form>

</body>
</html>