package br.com.casadocodigo.loja.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.cache.CacheBuilder;

import br.com.casadocodigo.loja.controllers.HomeControler;
import br.com.casadocodigo.loja.converters.IntegerToStringConverter;
import br.com.casadocodigo.loja.daos.ProdutoDao;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.model.CarrinhoCompras;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeControler.class,ProdutoDao.class,FileSaver.class,CarrinhoCompras.class})
@EnableCaching
public class AppWebConfiguration extends WebMvcConfigurerAdapter{

	@Bean // CONFIGURACOES SPRING DO VIEW RESOLVER
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		// DISPONIBILIZA O BEAN PARA ACESSO DESDE A JSP
		resolver.setExposedContextBeanNames("carrinhoCompras");
		
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
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new IntegerToStringConverter());
		super.addFormatters(registry);
	}
	
	@Bean //ATIVANDO O CACHE MANAGER DO SPRING
	public CacheManager cacheManager() {
		
		CacheBuilder<Object,Object> cachebuilder = CacheBuilder.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(5, TimeUnit.MINUTES);
		
		GuavaCacheManager cacheManager = new GuavaCacheManager();
		cacheManager.setCacheBuilder(cachebuilder);
		
		return cacheManager;
	}
	
	@Bean
	public ViewResolver ContentNegotiationViewResolver(ContentNegotiationManager manager){
		
		List<ViewResolver> viewResolvers = new ArrayList<>();
		viewResolvers.add(internalResourceViewResolver());
		viewResolvers.add(new JsonViewResolver());
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(viewResolvers);
		resolver.setContentNegotiationManager(manager);
		
		return resolver;
		
	}
	
}
