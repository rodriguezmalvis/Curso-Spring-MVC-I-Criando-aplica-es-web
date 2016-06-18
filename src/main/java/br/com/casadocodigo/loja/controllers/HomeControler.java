package br.com.casadocodigo.loja.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class HomeControler {
	
	@RequestMapping("/")
	public String index(){
		System.out.println("Entrando na home da Casa do Codigo");
		return "home";
	}

}
