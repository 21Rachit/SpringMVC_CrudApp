package purpledocs.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


import purpledocs.controllers.PatientController;
import purpledocs.dao.impl.PatientDAOImpl;

@Configuration
@ComponentScan(basePackages="purpledocs")
@EnableWebMvc
@PropertySource(value = { "classpath:db.properties", "classpath:sqlStatements.properties"})
public class PatientCRUDMvcConfig extends WebMvcConfigurerAdapter{

	@Value("${db.url}")
	private String dbUrl;
	@Value("${db.driver}")
	private String dbDriver;
	@Value("${db.username}")
	private String dbUser;
	@Value("${db.password}")
	private String dbPassword;
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(mysqlDataSource());
	}
	
	@Bean
	public DriverManagerDataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername(dbUser);
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(dbUrl);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
	
	@Bean
	public PatientController patientController() {
		return new PatientController();
	}
	
	@Bean
	public PatientDAOImpl patientDAOImpl() {
		return new PatientDAOImpl();
	}
}