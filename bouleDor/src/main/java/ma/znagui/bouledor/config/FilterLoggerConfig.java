package ma.znagui.bouledor.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.FilterChainProxy;

@Configuration
public class FilterLoggerConfig {

    @Bean
    CommandLineRunner printFilters(ApplicationContext context) {
        return args -> {
            FilterChainProxy filterChainProxy = context.getBean(FilterChainProxy.class);
            filterChainProxy.getFilterChains().forEach(chain -> {
                System.out.println("FILTER CHAIN:");
                chain.getFilters().forEach(filter -> System.out.println(" - " + filter.getClass().getName()));
            });
        };
    }
}
