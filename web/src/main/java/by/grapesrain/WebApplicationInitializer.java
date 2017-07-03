package by.grapesrain;

import by.grapesrain.config.ConfigDB;
import by.grapesrain.config.ConfigServices;
import by.grapesrain.config.ConfigWeb;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Alexandr on 02.07.2017.
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
//        return new Class[] {ConfigServices.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ConfigWeb.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
