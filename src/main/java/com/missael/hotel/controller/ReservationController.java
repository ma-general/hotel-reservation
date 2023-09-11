package com.missael.hotel.controller;

import com.missael.hotel.model.Reservation;
import com.missael.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public Set<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping
    public boolean createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping
    public boolean updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }
}
