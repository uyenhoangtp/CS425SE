package com.example.eregistrar.controller;

import com.example.eregistrar.model.Customer;
import com.example.eregistrar.model.Reservation;
import com.example.eregistrar.model.Vehicle;
import com.example.eregistrar.service.CustomerService;
import com.example.eregistrar.service.ReservationService;
import com.example.eregistrar.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final CustomerService customerService;
    private final VehicleService vehicleService;

    public ReservationController(ReservationService reservationService, CustomerService customerService, VehicleService vehicleService) {
        this.reservationService = reservationService;
        this.customerService = customerService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/list")
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservations/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("customers", customers);
        model.addAttribute("vehicles", vehicles);
        return "reservations/form";
    }

    @PostMapping("/save")
    public String saveReservation(@RequestParam Long customerId,
                                 @RequestParam Long vehicleId,
                                 @ModelAttribute Reservation reservation) {
        reservationService.saveReservation(customerId, vehicleId, reservation);
        return "redirect:/reservations/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations/list";
    }
}
