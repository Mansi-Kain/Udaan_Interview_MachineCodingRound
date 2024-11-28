package com.example.BusApp.Controller;

import com.example.BusApp.Service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class BusController {
    @Autowired
    BusService busService;

    @GetMapping("/searchBus")
    public List searchBus(@RequestParam  String Source,
                          @RequestParam String Destination,
                          @RequestParam String startTime){
        return busService.searchBus(Source,Destination,startTime);
    }

    @PostMapping("/reserveBus")
    public String reserveSeats(@RequestParam Long user_id,Long bus_id,Integer n){
        return busService.reserveSeat(user_id,bus_id,n);
    }
}
