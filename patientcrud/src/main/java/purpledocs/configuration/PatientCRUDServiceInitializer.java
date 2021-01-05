package purpledocs.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PatientCRUDServiceInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //replacing servlet-mvc-servlet.xml (contains servlet configuration)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { PatientCRUDMvcConfig.class };
    }

    //ServletMapping
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

   

}