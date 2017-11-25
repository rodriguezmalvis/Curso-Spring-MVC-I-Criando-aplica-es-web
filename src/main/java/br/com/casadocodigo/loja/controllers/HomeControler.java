package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDao;
import br.com.casadocodigo.loja.model.Produto;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class HomeControler {
	
	@Autowired
	private ProdutoDao dao;
	
	@RequestMapping("/")
	public ModelAndView index(){
		List<Produto> produtos = dao.lista();
		ModelAndView model = new ModelAndView("home");
		model.addObject("produtos", produtos);
		return model;
	}

}
