package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControler {
	
	@RequestMapping("/")
	public String index(){
		System.out.println("Entrando na home da Casa do Codigo");
		return "home";
	}

}
