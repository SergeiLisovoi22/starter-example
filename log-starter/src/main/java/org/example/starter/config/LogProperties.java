package org.example.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "logging.http")
public class LogProperties {
    private boolean enable = true;
    private String level = "INFO";

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isEnable() {
        return enable;
    }

    public String getLevel() {
        return level;
    }
}
