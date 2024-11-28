package com.example.BusApp.Service.Impl;

import com.example.BusApp.Entity.Bus;
import com.example.BusApp.Entity.Enum.Status;
import com.example.BusApp.Entity.Reservation;
import com.example.BusApp.Entity.Seat;
import com.example.BusApp.Entity.User;
import com.example.BusApp.Repository.BusRepository;
import com.example.BusApp.Repository.ReservationRepository;
import com.example.BusApp.Repository.SeatRepository;
import com.example.BusApp.Repository.UserRepository;
import com.example.BusApp.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public void addBus() {
        List<Bus> buses = new ArrayList<>();

        // 1st Bus
        Bus bus1 = new Bus();
        bus1.setCompanyName("Bus Company A");
        bus1.setBusNo("A123");
        bus1.setSource("City A");
        bus1.setDestination("City B");
        bus1.setStartTime(LocalDateTime.now().plusHours(1));
        bus1.setEndTime(LocalDateTime.now().plusHours(5));
        bus1.setCapacity(40L);
        List<Seat> seatsBus1 = createSeats(bus1, 40L);
        bus1.setSeats(seatsBus1);
        buses.add(bus1);
//       2nd Bus
        Bus bus2 = new Bus();
        bus2.setCompanyName("Bus Company B");
        bus2.setBusNo("B456");
        bus2.setSource("City C");
        bus2.setDestination("City D");
        bus2.setStartTime(LocalDateTime.now().plusHours(2));
        bus2.setEndTime(LocalDateTime.now().plusHours(6));
        bus2.setCapacity(30L);
        List<Seat> seatsBus2 = createSeats(bus2, 30L);
        bus2.setSeats(seatsBus2);
        buses.add(bus2);
//        3rd bus
        Bus bus3 = new Bus();
        bus3.setCompanyName("Bus Company C");
        bus3.setBusNo("C789");
        bus3.setSource("City E");
        bus3.setDestination("City F");
        bus3.setStartTime(LocalDateTime.now().plusHours(3));
        bus3.setEndTime(LocalDateTime.now().plusHours(7));
        bus3.setCapacity(50L);
        List<Seat> seatsBus3 = createSeats(bus3, 50L);
        bus3.setSeats(seatsBus3);
        buses.add(bus3);

        for (Bus bus : buses) {
            busRepository.save(bus);
        }
    }

//    method to create seats for a bus
    private List<Seat> createSeats(Bus bus, Long capacity) {
        List<Seat> seats = new ArrayList<>();
        for (long i = 1; i <= capacity; i++) {
            Seat seat = new Seat();
            seat.setSeatNumber(i);
            seat.setStatus(Status.AVAILABLE);
            seat.setBus(bus);
            seats.add(seat);
        }
        return seats;
    }


    @Override
    public List searchBus(String source, String Destination, String date) {

        LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        return busRepository.findAllBySourceAndDestinationAndStartTimeBetween(
                source,
                Destination,
                dateTime,
                dateTime.plusDays(1)
        );
    }

}
