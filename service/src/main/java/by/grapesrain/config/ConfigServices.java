package by.grapesrain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Configuration
@ComponentScan(basePackages = {"by.grapesrain.services"})
@ContextConfiguration(classes = ConfigDB.class)
@Import(value = {ConfigDB.class, AspectConfig.class})
public class ConfigServices {

}
