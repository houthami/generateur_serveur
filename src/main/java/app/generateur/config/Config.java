package app.generateur.config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public DBInitializer init(){
        return new DBInitializer();
    }

    /*public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        context.registerShutdownHook();

        System.out.println("-- accessing bean --");
        DBInitializer bean = context.getBean(DBInitializer.class);
        bean.init();

        System.out.println("-- finished --");
    }*/

}
