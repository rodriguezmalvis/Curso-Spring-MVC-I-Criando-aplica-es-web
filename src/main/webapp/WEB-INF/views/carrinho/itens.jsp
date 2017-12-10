<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate>

<p class="destaqueDoCupom">
  Use o código <strong class="destaqueDoCupom-codigo"></strong> e tenha <strong class="destaqueDoCupom-desconto">10%</strong> de desconto!
  <button class="destaqueDoCupom-remover" title="Remover banner" onclick="removeDiscountBanner()"><?xml version="1.0" encoding="iso-8859-1"?>
<!-- Generator: Adobe Illustrator 16.0.0, SVG Export Plug-In . SVG Version: 6.00 Build 0)  -->
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
	 width="15px" height="15px" viewBox="0 0 612 612" style="enable-background:new 0 0 612 612;" xml:space="preserve">
<g>
	<path fill="#ffffff" d="M387.128,170.748L306,251.915l-81.128-81.167l-54.124,54.124L251.915,306l-81.128,81.128l54.085,54.086L306,360.086
		l81.128,81.128l54.086-54.086L360.086,306l81.128-81.128L387.128,170.748z M522.38,89.62
		c-119.493-119.493-313.267-119.493-432.76,0c-119.493,119.493-119.493,313.267,0,432.76
		c119.493,119.493,313.267,119.493,432.76,0C641.873,402.888,641.873,209.113,522.38,89.62z M468.295,468.295
		c-89.62,89.619-234.932,89.619-324.551,0c-89.62-89.62-89.62-234.932,0-324.551c89.62-89.62,234.931-89.62,324.551,0
		C557.914,233.363,557.914,378.637,468.295,468.295z"/>
</g>
</svg>
</button>
</p>

		<section class="infoSection container">
	<h2 class="infoSection-titulo">Seu carrinho</h2>
	
	<table class="formularioDoCarrinho-tabela">
		<thead class="formularioDoCarrinho-cabecalho">
			<tr>
				<th></th>
				<th class="formularioDoCarrinho-cabecalho-item">Item</th>
				<th class="formularioDoCarrinho-cabecalho-item formularioDoCarrinho-cabecalho-preco">Preço</th>
				<th class="formularioDoCarrinho-cabecalho-item">Qtd</th>
				<th class="formularioDoCarrinho-cabecalho-item">Total</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrinhoCompras.itens }" var="item">
			<tr>
				<td class="formularioDoCarrinho-item">
					<a href="/products/livro-java8">
						<img class="formularioDoCarrinho-item-imagem" src="//cdn.shopify.com/s/files/1/0155/7645/products/java8-featured_small.png?v=1411490181" />
					</a>
				</td>
				<td class="formularioDoCarrinho-item">
					<h2 class="formularioDoCarrinho-item-titulo">${item.produto.titulo }</h2>
				</td>
				<td class="formularioDoCarrinho-item formularioDoCarrinho-item-preco">${item.preco }</td>
				<td class="formularioDoCarrinho-item">
					<input class="formularioDoCarrinho-item-quantidade"
						   type="number"
						   min="0"
						   id="quantidade"
						   name="quantidade"
						   value="${carrinhoCompras.getQuantidade(item) }">
				</td>
				<td class="formularioDoCarrinho-item formularioDoCarrinho-item-precoTotal" title="Preço unitário: R$39,90">${carrinhoCompras.getTotal(item) }</td>
				<td class="formularioDoCarrinho-item">
				<form:form action="carrinho/remover" method="post">
					<input type="hidden" name="produtoId" value="${item.produto.id }" />
					<input type="hidden" name="tipoPreco" value="${item.tipoPreco }" />
					<input type="image" class="formularioDoCarrinho-item-remover-imagem"  src="//cdn.shopify.com/s/files/1/0155/7645/t/222/assets/trash.png?4785041998831679862" alt="X" title="Remover">
				</form:form>
				</td>
			</tr>
			</c:forEach>
			
		</tbody>
		<tfoot class="formularioDoCarrinho-rodape">
			<tr>
				<td class="formularioDoCarrinho-rodape-item formularioDoCarrinho-finalizar" colspan="3">
				<form:form action="${s:mvcUrl('PC#finalizar').build() }" method="post">
					<button class="formularioDoCarrinho-finalizar-botao" type="submit" name="checkout">Finalizar
					<span class="formularioDoCarrinho-finalizar-botao-texto" role="presentation"> compra</span></button>
				</form:form>
				</td>
				<td class="formularioDoCarrinho-rodape-item">
					${carrinhoCompras.total }
				</td>
				<td></td>
			</tr>
		</tfoot>
	</table>
	
</section>

	<script type="text/javascript" src="//cdn.shopify.com/s/files/1/0155/7645/t/222/assets/trackExternalLinks.js?4785041998831679862"></script>
	
	<script type="text/javascript" src="//cdn.shopify.com/s/files/1/0155/7645/t/222/assets/userreport.js?4785041998831679862"></script>
	<script type="text/javascript" src="//cdn.shopify.com/s/files/1/0155/7645/t/222/assets/discount.js?4785041998831679862"></script>
</body>
</html>

</tags:pageTemplate>
