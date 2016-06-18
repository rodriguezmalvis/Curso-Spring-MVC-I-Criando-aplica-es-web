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

	<h1>Lista de Produtos</h1>
	
	<div>${sucesso }</div>
	
	<table>
		<tr>
			<td>Título</td>
			<td>Descriçao</td>
			<td>Páginas</td>
		</tr>
		 	<c:forEach items="${produtos }" var="produto">
		 		<tr>
		 			<td>
		 				<a href="produtos/detalhe/${produto.id }">${produto.titulo }</a>
		 			</td>
		 			<td>${produto.descricao }</td>
		 			<td>${produto.paginas }</td>
		 		</tr>
		 	</c:forEach>
	</table>

</body>
</html>