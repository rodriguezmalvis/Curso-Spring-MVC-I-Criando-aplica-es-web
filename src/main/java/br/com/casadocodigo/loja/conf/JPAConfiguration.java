package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {
	
	@Bean //CONFIGURACOES DO JPA PASSADAS PRO SPRING
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean factorybean = new LocalContainerEntityManagerFactoryBean();
		
		JpaVendorAdapter vendoradapter = new HibernateJpaVendorAdapter();
		factorybean.setJpaVendorAdapter(vendoradapter);
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUsername("root");
		datasource.setPassword("Ramses2010");
		datasource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		
		/*DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUsername("sa");
		datasource.setPassword("Ramses2010");
		datasource.setUrl("jdbc:sqlserver://localhost\\SQL2016CAC080;databaseName=casadocodigo");
		datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");*/
		
		factorybean.setDataSource(datasource);
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		//props.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		
		factorybean.setJpaProperties(props);
		
		factorybean.setPackagesToScan("br.com.casadocodigo.loja.model");
		
		return factorybean;
	}
	
	@Bean //CONFIGURACAO PARA QUE O SPRING GERENCIE AS TRANSACOES AUTOMATICAMENTE
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}

}
