package com.example.BusApp.Service;

import com.example.BusApp.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    void addUser();
    List viewReservations(Long user_id);
}
