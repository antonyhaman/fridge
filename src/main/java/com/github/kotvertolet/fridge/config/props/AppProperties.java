package com.github.kotvertolet.fridge.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "fridge.server.info")
@Getter
@Setter
public class AppProperties {

    private String displayName;
    private String name;
    private String description;
    private Date startTime = new Date();
    private String buildNumber;
    private Map<String, String> extraInfo;
    private boolean swagger = false;

    @Override
    public String toString() {
        return "AppProperties{" +
                "displayName='" + displayName + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", buildNumber='" + buildNumber + '\'' +
                ", extraInfo=" + extraInfo +
                ", swagger=" + swagger +
                '}';
    }
}
