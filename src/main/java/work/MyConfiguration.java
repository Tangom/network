package work;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan(basePackages = "work")
public class MyConfiguration {
    @Bean
    public EntityManagerFactory getFactory() {
        return  Persistence.createEntityManagerFactory("TestPersistenceUnit");
    }
    @Bean
    public EntityManager getEntityManager (EntityManagerFactory emf){
        return emf.createEntityManager();
    }
    @Bean
    public ViewResolver getResolver (){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver ();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
