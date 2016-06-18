package br.com.casadocodigo.loja.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProdutoValidation implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors erros) {
		
		ValidationUtils.rejectIfEmpty(erros, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(erros, "descricao", "field.required");
		
		Produto produto = (Produto) target;
		if(produto.getPaginas() <= 0){
			erros.rejectValue("paginas", "field.required");
		}
		
	}

}
