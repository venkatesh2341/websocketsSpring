package com.uber.websocket_server.DTO.Chat;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatResponse {
    private String name;
    private String message;
    private String timestamp;
}
