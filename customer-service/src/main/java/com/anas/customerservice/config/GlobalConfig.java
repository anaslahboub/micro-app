package com.anas.customerservice.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "global.params")
@RefreshScope
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class GlobalConfig {
    private int p1;
    private int p2;
}
