package br.com.casadocodigo.loja.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{SecurityConfiguration.class};
	}

	@Override //CLASSES DE CONFIGURACOES PASSADAS PRO SPRING
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{AppWebConfiguration.class,JPAConfiguration.class};
	}

	@Override // MAPEAMENTO INICIAL DO SERVLET SPRING (FRONT CONTROLER)
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	
	@Override //CONFIGURACAO PARA SETAR O SPRING ENCODED (O ECLIPSE DEVERIA MUDAR TB PARA ESTE ENCODED)
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[]{characterEncodingFilter};
	}
	
	@Override //CONFIGURACAO PARA ATIVAR A RECEBIMENTO DE ARQUIVOS MULTIPART NAS REQUISICOES (VER CONFIGURACOES AppWebConfiguration TB)
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}

}
