package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //para indicar que esto es una clase de configuración
@ComponentScan(basePackages = "controller") //para indicar que es un controlador
@EnableWebMvc //habilita configuraciones
public class ControllerConfig {
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() { //objeto para resolver las vistas
	 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 resolver.setPrefix("/");
	 resolver.setSuffix(".jsp");
	 return resolver;
	}

}
