package by.grapesrain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by PloSkiY on 02.07.2017.
 */
@Configuration
@ComponentScan(basePackages = "by.grapesrain.controller")
@EnableWebMvc
@Import(value = {ThymeleafConfig.class, ConfigServices.class, InternationalizationConfig.class})
public class ConfigWeb {


}
