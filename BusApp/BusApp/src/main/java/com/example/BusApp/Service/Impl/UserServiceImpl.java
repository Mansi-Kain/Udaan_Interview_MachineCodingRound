package com.example.BusApp.Service.Impl;

import com.example.BusApp.Entity.Reservation;
import com.example.BusApp.Entity.Seat;
import com.example.BusApp.Entity.User;
import com.example.BusApp.Repository.UserRepository;
import com.example.BusApp.Service.UserService;
import com.example.BusApp.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser() {
        User user1 = new User();
        user1.setName("John");

        User user2 = new User();
        user2.setName("Mohit");

        User user3 = new User();
        user3.setName("Mansi");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    @Override
    public List<ReservationDto> viewReservations(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return user.getReservations().stream().map(reservation -> {
            ReservationDto dto = new ReservationDto();
            dto.setId(reservation.getId());
            dto.setUserId(userId);
            dto.setBusId(reservation.getBus().getId());

            List<Long> seatIds = reservation.getSeats().stream()
                    .map(Seat::getId)
                    .collect(Collectors.toList());
            dto.setSeatIds(seatIds);

            return dto;
        }).collect(Collectors.toList());
    }
}
