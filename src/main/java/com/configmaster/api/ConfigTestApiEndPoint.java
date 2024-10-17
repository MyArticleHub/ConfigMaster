package com.configmaster.api;

import com.configmaster.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigTestApiEndPoint {
    private final AppProperties appProperties;

    @Autowired
    public ConfigTestApiEndPoint(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/info")
    public String getAppInfo() {
        return "App Name: " + appProperties.getName() +
                ", Description: " + appProperties.getDescription() +
                ", Version: " + appProperties.getVersion();
    }
}
