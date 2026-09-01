package com.example.rentacar.controller;

import com.example.rentacar.service.CustomerService;
import com.example.rentacar.service.ReservationService;
import com.example.rentacar.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CustomerService customerService;
    private final VehicleService vehicleService;
    private final ReservationService reservationService;

    public HomeController(CustomerService customerService, VehicleService vehicleService, ReservationService reservationService) {
        this.customerService = customerService;
        this.vehicleService = vehicleService;
        this.reservationService = reservationService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("customersCount", customerService.getAllCustomers().size());
        model.addAttribute("vehiclesCount", vehicleService.getAllVehicles().size());
        model.addAttribute("reservationsCount", reservationService.getAllReservations().size());
        model.addAttribute("pageTitle", "RentaCar Dashboard");
        return "index";
    }
}
