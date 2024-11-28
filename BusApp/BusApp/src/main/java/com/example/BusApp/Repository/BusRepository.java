package com.example.BusApp.Repository;

import com.example.BusApp.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Long> {

    List<Bus> findAllBySourceAndDestinationAndStartTimeBetween(String source, String destination, LocalDateTime startTime, LocalDateTime endTime);
}
