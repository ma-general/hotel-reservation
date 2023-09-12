package com.missael.hotel.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
public class Reservation implements Serializable {
    private Integer id;
    private String clientFullName;
    private Integer roomNumber;
    private List<LocalDate> reservationDates;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return clientFullName.equals(that.clientFullName) && roomNumber.equals(that.roomNumber) && reservationDates.equals(that.reservationDates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientFullName, roomNumber, reservationDates);
    }
}
