package org.example.app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return null;
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{AppConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
public void onStartup(ServletContext container) throws ServletException {
    AnnotationConfigWebApplicationContext ctx =
            new AnnotationConfigWebApplicationContext();
    ctx.register(AppConfig.class);

    ctx.setServletContext(container);
    ServletRegistration.Dynamic servlet =
            container.addServlet("dispatcher", new DispatcherServlet(ctx));

    servlet.setLoadOnStartup(1);
    servlet.addMapping("/");
}


}

