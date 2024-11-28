package com.example.BusApp.Dto;

import com.example.BusApp.Entity.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatDto {
    private Long id;
    private Long seatNumber;
    private Status status;
    private Long busId;
    private Long reservationId;
}
