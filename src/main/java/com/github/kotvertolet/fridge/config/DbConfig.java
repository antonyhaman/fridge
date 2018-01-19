package com.github.kotvertolet.fridge.config;

import com.github.kotvertolet.fridge.config.props.DbProperties;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class DbConfig {

    private final DbProperties dbProperties;

    public DbConfig(@Autowired DbProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

    @Bean
    public MongoDbFactory mongoDbFactory(@Autowired MongoClient mongo) {
        return new SimpleMongoDbFactory(mongo, dbProperties.getDb());
    }

    @Bean
    public MongoTemplate mongoTemplate(@Autowired MongoDbFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }
}
