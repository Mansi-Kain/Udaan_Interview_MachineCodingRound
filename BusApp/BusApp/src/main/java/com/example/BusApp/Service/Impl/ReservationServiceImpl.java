package com.example.BusApp.Service.Impl;

import com.example.BusApp.Entity.Bus;
import com.example.BusApp.Entity.Enum.Status;
import com.example.BusApp.Entity.Reservation;
import com.example.BusApp.Entity.Seat;
import com.example.BusApp.Entity.User;
import com.example.BusApp.Repository.BusRepository;
import com.example.BusApp.Repository.ReservationRepository;
import com.example.BusApp.Repository.UserRepository;
import com.example.BusApp.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    BusRepository busRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public String reserveSeat(Long user_id, Long bus_id, Integer n) {
        Bus bus=busRepository.findById(bus_id).orElseThrow();
        User user=userRepository.findById(user_id).orElseThrow();
        Reservation reservation=new Reservation();
        List<Seat>seats=bus.getSeats();
        int availableSeats=0;
        for(Seat seat:seats){
            if(seat.getStatus().equals(Status.AVAILABLE)){
                availableSeats++;
            }
        }
        if(availableSeats>=n){
            reservation.setBus(bus);
            reservation.setUser(user);

            List<Seat> updatedSeats = new ArrayList<>();
            for (Seat seat : seats) {
                if (seat.getStatus().equals(Status.AVAILABLE)) {
                    seat.setStatus(Status.BOOKED);
                }
                seat.setReservation(reservation);
                updatedSeats.add(seat);
            }

            reservation.setSeats(updatedSeats);
            reservationRepository.save(reservation);
            return "SEATS RESERVED SUCCESSFULLY";
        }
        else return "REQUIRED NUMBER OF SEATS NOT AVAILABLE";
    }
}
