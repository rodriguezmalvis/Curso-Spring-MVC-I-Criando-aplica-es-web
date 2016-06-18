package br.com.casadocodigo.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeControler;
import br.com.casadocodigo.loja.daos.ProdutoDao;
import br.com.casadocodigo.loja.infra.FileSaver;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeControler.class,ProdutoDao.class,FileSaver.class})
public class AppWebConfiguration {

	@Bean // CONFIGURACOES SPRING DO VIEW RESOLVER
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Bean // CONFIGURACOES DO SPRING BEAN VALIDATOR (ENCODED E PATH DO ARQUIVO MESSAGE.PROPERTIES)
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename("/WEB-INF/message");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}
	
	@Bean // CONFIGURACOES AUTOMATICAS DO PATTERN NAS TAGS @DateTimeFormat DOS MODELOS
	public FormattingConversionService mvcConversionService(){
		
		FormattingConversionService conversionService = new FormattingConversionService();
		
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
		
	}
	
	@Bean //CONFIGURACAO PARA ATIVAR RESOLVER DE REQUISICOES MULTIPART NO SERVLET (VER CONFIGURACOES ServletSpringMVC TB)
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}
	
}
