package boot.examples;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class Example7 {

    public static void main(String args[]) {
        SpringApplication.run(Example7.class);
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
 
    @Bean 
    public ReloadableResourceBundleMessageSource messageSource() { 
    	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource(); 
    	messageSource.setBasename("classpath:locale/messages"); 
    	messageSource.setCacheSeconds(3600); //refresh cache once per hour return messageSource;
    	return messageSource;
    }
}

