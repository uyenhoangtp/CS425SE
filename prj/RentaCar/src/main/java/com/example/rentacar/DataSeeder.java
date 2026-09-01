package com.example.rentacar;

import com.example.rentacar.model.Customer;
import com.example.rentacar.model.Reservation;
import com.example.rentacar.model.Vehicle;
import com.example.rentacar.repository.CustomerRepository;
import com.example.rentacar.repository.ReservationRepository;
import com.example.rentacar.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner loadSampleData(CustomerRepository customerRepository,
                                            VehicleRepository vehicleRepository,
                                            ReservationRepository reservationRepository) {
        return args -> {
            if (customerRepository.count() == 0) {
                Customer customer1 = new Customer();
                customer1.setFirstName("Alice");
                customer1.setLastName("Johnson");
                customer1.setEmail("alice@example.com");
                customer1.setPhone("+1-202-555-0101");
                customer1.setLicenseNumber("ABC123");
                customer1.setAddress("Fairfield, IA");
                customerRepository.save(customer1);

                Customer customer2 = new Customer();
                customer2.setFirstName("Michael");
                customer2.setLastName("Brown");
                customer2.setEmail("michael@example.com");
                customer2.setPhone("+1-202-555-0102");
                customer2.setLicenseNumber("XYZ789");
                customer2.setAddress("Ames, IA");
                customerRepository.save(customer2);
            }

            if (vehicleRepository.count() == 0) {
                Vehicle vehicle1 = new Vehicle();
                vehicle1.setPlateNumber("ABC-123");
                vehicle1.setMake("Toyota");
                vehicle1.setModel("Camry");
                vehicle1.setVehicleType("Sedan");
                vehicle1.setDailyRate(65.0);
                vehicle1.setStatus("AVAILABLE");
                vehicleRepository.save(vehicle1);

                Vehicle vehicle2 = new Vehicle();
                vehicle2.setPlateNumber("XYZ-987");
                vehicle2.setMake("Honda");
                vehicle2.setModel("CR-V");
                vehicle2.setVehicleType("SUV");
                vehicle2.setDailyRate(95.0);
                vehicle2.setStatus("AVAILABLE");
                vehicleRepository.save(vehicle2);
            }

            if (reservationRepository.count() == 0) {
                Customer customer = customerRepository.findAll().get(0);
                Vehicle vehicle = vehicleRepository.findAll().get(0);

                Reservation reservation = new Reservation();
                reservation.setCustomer(customer);
                reservation.setVehicle(vehicle);
                reservation.setStartDate(LocalDate.now());
                reservation.setEndDate(LocalDate.now().plusDays(3));
                reservation.setStatus("PENDING");
                reservation.setTotalPrice(195.0);
                reservationRepository.save(reservation);
            }
        };
    }
}
