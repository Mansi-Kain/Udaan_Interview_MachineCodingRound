package com.example.BusApp.Service;

import com.example.BusApp.Entity.Bus;
import com.example.BusApp.Entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


public interface BusService {
    void addBus();
    List searchBus(String source , String Destination , String startTime);
}
