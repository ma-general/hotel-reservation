package com.missael.hotel.service;

import com.missael.hotel.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Optional;
import java.util.Set;

import static com.missael.hotel.util.Constants.FILEPATH;

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

    @PreDestroy
    public void saveReservationsInFile() throws IOException {
        System.out.println("Saving Reservations in File");
        FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(reservations);
        objectOutputStream.close();
    }

    @PostConstruct
    public void readReservationsFromFile() {
        Set<Reservation> reservationsFromFile = null;
        try {
            System.out.println("Reading Reservations from File");
            FileInputStream fileInputStream = new FileInputStream(FILEPATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            reservationsFromFile = (Set<Reservation>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (EOFException eofException) {
            System.out.println("End of file reached");
        } catch (FileNotFoundException eofException) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            Optional.ofNullable(reservationsFromFile)
                    .ifPresent( reservations -> this.reservations = reservations);
        }
    }

}
