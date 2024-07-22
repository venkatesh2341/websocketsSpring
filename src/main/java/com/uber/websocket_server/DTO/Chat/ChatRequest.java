package com.uber.websocket_server.DTO.Chat;

import lombok.*;
import org.springframework.scheduling.annotation.Scheduled;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRequest {
    private String name;
    private String message;
}
