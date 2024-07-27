package com.uber.websocket_server.DTO.Ride;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideRequestDto {

    private Long passengerId;
//    private ExactLocation startLocation;
//    private ExactLocation endLocation;
    private List<Long> driverIds;

    private Long bookingId;
}

