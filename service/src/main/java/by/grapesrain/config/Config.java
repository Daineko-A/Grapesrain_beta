package by.grapesrain.config;

import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by PloSkiY on 01.07.2017.
 */
@Configuration
@ComponentScan(basePackages = {"by.grapesrain.services"})
@ContextConfiguration(classes = Config.class)
@Import(Config.class)
public class Config {

}
