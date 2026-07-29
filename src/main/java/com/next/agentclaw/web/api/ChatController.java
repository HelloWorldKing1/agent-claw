package com.next.agentclaw.web.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/agents/{agentId}/chat")
public class ChatController {

    @GetMapping("/stream")
    public Flux<String> stream(String message, String agentId){
        return Flux.just();
    }
}
