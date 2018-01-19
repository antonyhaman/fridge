package com.github.kotvertolet.fridge.config;

import com.github.kotvertolet.fridge.config.props.DbProperties;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.github.kotvertolet.fridge.config.swagger.SwaggerConfig;

import java.util.Collections;

@Configuration
@Import({SwaggerConfig.class, DbConfig.class})
@PropertySource(value = "classpath:application.yaml")
@EnableMongoRepositories("tk.haman.fridge.repositories")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private DbProperties dbProperties;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

//    @Bean
//    public MongoClientFactoryBean mongo() {
//        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
//        mongo.setHost(dbProperties.getHost());
//        mongo.setPort(dbProperties.getPort());
//        mongo.setCredentials(new MongoCredential[]{MongoCredential.createCredential(dbProperties.getUsername(), dbProperties.getDb(), dbProperties.getPassword().toCharArray())});
//        mongo.setExceptionTranslator(new MongoExceptionTranslator());
//        return mongo;
//    }

    @Bean
    public MongoClient mongoClient() {
        //singletonList(MongoCredential.createCredential("",dbProperties.getDb(), "".toCharArray()))
        ServerAddress svr = new ServerAddress(dbProperties.getHost(), dbProperties.getPort());
        return new MongoClient(svr);
    }

    @Bean
    public CustomConversions mongoCustomConversions() {
        return new CustomConversions(Collections.emptyList());
    }
}
