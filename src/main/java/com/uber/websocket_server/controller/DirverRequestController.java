package com.uber.websocket_server.controller;

import com.uber.websocket_server.DTO.Ride.DriverResponseDto;
import com.uber.websocket_server.DTO.Ride.RideRequestDto;
import com.uber.websocket_server.DTO.Ride.RideResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/socket")
public class DirverRequestController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    DirverRequestController(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate= simpMessagingTemplate;
    }

    @PostMapping("/newride")
    public ResponseEntity<Boolean> raiseRideRequest(@RequestBody RideRequestDto rideRequestDto){
        System.out.println(rideRequestDto.getDriverIds() + " " + rideRequestDto.getBookingId() + " " + rideRequestDto.getBookingId());

        sendDriversNewRideRequest(rideRequestDto);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    public void sendDriversNewRideRequest(RideRequestDto rideRequestDto){
//        System.out.println(rideRequestDto.getDriverIds() + " " + rideRequestDto.getBookingId() + " " + rideRequestDto.getBookingId());
        simpMessagingTemplate.convertAndSend("/topic/rideRequest", rideRequestDto);
    }

    @MessageMapping("/driverResponse")
    public void driverResponseHandler(DriverResponseDto driverResponseDto){
        System.out.println(driverResponseDto.getResponse());
    }
}
