package com.missael.hotel.service;

import com.missael.hotel.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReservationService {

    private Set<Reservation> reservations;

    @Autowired
    public ReservationService(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Reservation> getAllReservations() {
        return reservations;
    }

    public boolean createReservation(Reservation reservation) {
        return reservations.add(reservation);
    }

    public boolean updateReservation(Reservation reservation) {
        if (reservations.contains(reservation)) {
            reservations.remove(reservation);
            reservations.add(reservation);
            return true;
        }
        return false;
    }

}
