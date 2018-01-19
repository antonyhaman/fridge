package com.github.kotvertolet.fridge.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")
@Getter
@Setter
public class DbProperties {

    private String host;
    private Integer port;
    private String db;
    private String username;
    private String password;
    private String showSql;
    private String autocommit;
    private String driver;
    private String dialect;
    private String action;
}
