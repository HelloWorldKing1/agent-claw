package com.next.agentclaw.web.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ClawProperties {
    @Value("${claw.home:#{systemProperties['user.home']}/.agentscope/claw}")
    private String clawHome;

    @Getter
    @Value("${claw.dashscope.api-key:}")
    private String dashscopeApiKey;

    @Getter
    @Value("${claw.dashscope.model-name:qwen-max}")
    private String dashscopeModelName;

    @Getter
    @Value("${claw.dashscope.stream:true}")
    private boolean dashscopeStream;

    public Path resolveClawHome() {
        String raw = clawHome != null && !clawHome.isBlank() ? clawHome : "~/.agentscope/claw";
        if (raw.startsWith("~")) {
            raw = System.getProperty("user.home") + raw.substring(1);
        }
        return Paths.get(raw).toAbsolutePath().normalize();
    }
}
