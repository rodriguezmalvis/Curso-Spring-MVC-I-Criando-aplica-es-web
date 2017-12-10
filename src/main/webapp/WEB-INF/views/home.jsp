<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate>

<h3 class="homeCall container">ConheÃ§a todos os nossos livros</h3>

<section class="vitrineDaColecao container">
	<ul class="vitrineDaColecao-lista">
			
		<c:forEach items="${produtos}" var="produto">
		
		<li class="livroNaVitrine vitrineDaColecao-produto">
			<a href="produtos/detalhe/${produto.id }" class="livroNaVitrine-link" title="Front-end com Vue.js: Da teoria Ã  prÃ¡tica sem complicaÃ§Ãµes">
			<div class="livroNaVitrine-imagemContainer" role="presentation">
				<img class="livroNaVitrine-imagem " src="//cdn.shopify.com/s/files/1/0155/7645/products/Amazon-Front-end-com-Vue-js_large.jpg?v=1511489591" alt="Livro de Front-end com Vue.js" title="Livro de Front-end com Vue.js">
			</div>
			<span class="livroNaVitrine-nome">
				
			${produto.titulo}
		
			</span>
			</a>
		</li>
		
		</c:forEach>
	</ul>
	</section>

	<script type="text/javascript" src="//cdn.shopify.com/s/files/1/0155/7645/t/227/assets/trackExternalLinks.js?3991845547729861854"></script>
	
	<script type="text/javascript" src="//cdn.shopify.com/s/files/1/0155/7645/t/227/assets/userreport.js?3991845547729861854"></script>
	<script type="text/javascript" src="//cdn.shopify.com/s/files/1/0155/7645/t/227/assets/discount.js?3991845547729861854"></script>
</body>
</html>

</tags:pageTemplate>
