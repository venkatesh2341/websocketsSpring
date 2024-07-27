package com.uber.websocket_server.DTO.Ride;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RideResponseDto {
    public Boolean response;
    public Long bookingId;
}