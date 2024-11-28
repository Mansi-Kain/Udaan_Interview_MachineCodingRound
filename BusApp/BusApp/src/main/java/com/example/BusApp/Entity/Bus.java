package com.example.BusApp.Entity;

import com.example.BusApp.Entity.Enum.Frequency;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String busNo;

    private String source;

    private String destination;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private List<Frequency> frequency;

    private Long capacity;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Bus(Long id){
        this.id =id;
    }
}
