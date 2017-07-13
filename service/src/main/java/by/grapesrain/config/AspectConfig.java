package by.grapesrain.config;

import by.grapesrain.aspect.ServLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by PloSkiY on 09.07.2017.
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public ServLogger logger() {
        return new ServLogger();
    }
}
