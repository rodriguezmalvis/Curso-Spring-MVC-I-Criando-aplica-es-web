package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.jws.WebParam;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDao;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.ProdutoValidation;
import br.com.casadocodigo.loja.model.TipoPreco;

@Controller
@RequestMapping("/produtos")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class ProdutosController {
	
	@Autowired
	private ProdutoDao produtodao;
	
	@Autowired
	private FileSaver filesaver;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		binder.addValidators(new ProdutoValidation());
	}

	@RequestMapping("/form")
	public ModelAndView form(Produto produto){
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos",TipoPreco.values());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value="produtosHome",allEntries=true)
	public ModelAndView grava(MultipartFile sumario, @Valid Produto produto,BindingResult result,RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return form(produto);
		}
		
		String path = filesaver.write("arquivos_sumario", sumario);
		produto.setSumarioPath(path);
		
		System.out.println(produto);
		produtodao.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso","Produto cadstrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		List<Produto> produtos = produtodao.lista();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos",produtos);
		return modelAndView;
	}
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		Produto produto = produtodao.find(id);
		modelAndView.addObject("produto", produto);
		return modelAndView;
	}
	
}
