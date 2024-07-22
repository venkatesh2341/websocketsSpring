package com.uber.websocket_server.DTO;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Greetings {
    private String message;
}
