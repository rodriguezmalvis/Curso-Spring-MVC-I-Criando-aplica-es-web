package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.model.CarrinhoCompras;
import br.com.casadocodigo.loja.model.DadosPagamento;

@Controller
@RequestMapping("/pagamento")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/finalizar")
	public Callable<ModelAndView> finalizar(RedirectAttributes model){
		
		return() -> {
			
			String url = "http://book-payment.herokuapp.com/payment";
			
			try {
				String response = restTemplate.postForObject(url, new DadosPagamento(carrinho.getTotal()), String.class);
				
				System.out.println(response);
				
				model.addFlashAttribute("sucesso", response);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Valor maior que o permitido");
				model.addFlashAttribute("sucesso", "Valor maior que o permitido");
				return new ModelAndView("redirect:/produtos");
			}
			
			return new ModelAndView("redirect:/produtos");
			
		};
		
		
	}

}
