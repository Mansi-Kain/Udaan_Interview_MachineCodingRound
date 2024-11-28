package com.example.BusApp;

import com.example.BusApp.Entity.Bus;
import com.example.BusApp.Repository.BusRepository;
import com.example.BusApp.Service.BusService;
import com.example.BusApp.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class BusAppApplication {

	private final BusService busService;
	private final UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BusAppApplication.class, args);
	}

	@Bean
	public boolean add(){
		busService.addBus();
		userService.addUser();
		return true;
	}

}
