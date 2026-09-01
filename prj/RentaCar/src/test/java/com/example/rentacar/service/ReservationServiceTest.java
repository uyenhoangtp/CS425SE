package com.example.rentacar.service;

import com.example.rentacar.model.Customer;
import com.example.rentacar.model.Reservation;
import com.example.rentacar.model.Vehicle;
import com.example.rentacar.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private CustomerService customerService;

    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    void shouldCalculateTotalPriceForReservation() {
        Customer customer = new Customer();
        customer.setId(1L);

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setDailyRate(50.0);

        Reservation reservation = new Reservation();
        reservation.setStartDate(LocalDate.now());
        reservation.setEndDate(LocalDate.now().plusDays(3));

        when(customerService.getCustomerById(1L)).thenReturn(customer);
        when(vehicleService.getVehicleById(1L)).thenReturn(vehicle);
        when(reservationRepository.save(any(Reservation.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Reservation result = reservationService.saveReservation(1L, 1L, reservation);

        assertEquals(150.0, result.getTotalPrice());
        assertEquals("PENDING", result.getStatus());
    }
}
