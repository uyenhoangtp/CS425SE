package com.example.eregistrar.service;

import com.example.eregistrar.model.Customer;
import com.example.eregistrar.model.Reservation;
import com.example.eregistrar.model.Vehicle;
import com.example.eregistrar.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerService customerService;
    private final VehicleService vehicleService;

    public ReservationService(ReservationRepository reservationRepository, CustomerService customerService, VehicleService vehicleService) {
        this.reservationRepository = reservationRepository;
        this.customerService = customerService;
        this.vehicleService = vehicleService;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Long customerId, Long vehicleId, Reservation reservation) {
        Customer customer = customerService.getCustomerById(customerId);
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);

        if (reservation.getStartDate() == null || reservation.getEndDate() == null) {
            throw new RuntimeException("Reservation dates are required");
        }

        if (!reservation.getEndDate().isAfter(reservation.getStartDate())) {
            throw new RuntimeException("End date must be after start date");
        }

        long days = ChronoUnit.DAYS.between(reservation.getStartDate(), reservation.getEndDate());
        double totalPrice = vehicle.getDailyRate() * (days > 0 ? days : 1);

        reservation.setCustomer(customer);
        reservation.setVehicle(vehicle);
        reservation.setStatus("PENDING");
        reservation.setTotalPrice(totalPrice);

        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
