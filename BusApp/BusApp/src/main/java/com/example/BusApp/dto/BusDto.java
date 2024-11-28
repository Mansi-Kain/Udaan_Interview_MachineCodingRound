package com.example.BusApp.Dto;

import com.example.BusApp.Entity.Enum.Frequency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusDto {
    private Long id;
    private String companyName;
    private String busNo;
    private String source;
    private String destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Frequency> frequency;
    private Long capacity;
}
