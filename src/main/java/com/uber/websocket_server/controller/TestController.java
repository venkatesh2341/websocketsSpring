package com.uber.websocket_server.controller;

import com.uber.websocket_server.DTO.Greetings;
import com.uber.websocket_server.DTO.TestRequest;
import com.uber.websocket_server.DTO.TestResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    TestController(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate= simpMessagingTemplate;
    }

    // client to server info passing contains prefix address as well( /app)
    @MessageMapping("/ping")
    @SendTo("/topic/ping")  // server to client info passing
    public TestResponse pingCheck(TestRequest request){
//        System.out.println(request.data + " hahah");
        return TestResponse.builder()
                .data(request.data).build();
    }


    @Scheduled(fixedDelay = 2000)
    public void greet(){
        simpMessagingTemplate.convertAndSend("/topic/greeting", "Time is "+ System.currentTimeMillis());
    }
}

