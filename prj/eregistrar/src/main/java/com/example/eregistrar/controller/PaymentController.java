package com.example.eregistrar.controller;

import com.example.eregistrar.model.Payment;
import com.example.eregistrar.model.Reservation;
import com.example.eregistrar.service.PaymentService;
import com.example.eregistrar.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final ReservationService reservationService;

    public PaymentController(PaymentService paymentService, ReservationService reservationService) {
        this.paymentService = paymentService;
        this.reservationService = reservationService;
    }

    @GetMapping("/list")
    public String listPayments(Model model) {
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments", payments);
        return "payments/list";
    }

    @GetMapping("/new/{reservationId}")
    public String showCreateForm(@PathVariable Long reservationId, Model model) {
        Reservation reservation = reservationService.getAllReservations().stream()
                .filter(r -> r.getId().equals(reservationId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        model.addAttribute("reservation", reservation);
        model.addAttribute("payment", new Payment());
        return "payments/form";
    }

    @PostMapping("/save/{reservationId}")
    public String savePayment(@PathVariable Long reservationId, @ModelAttribute Payment payment) {
        Reservation reservation = reservationService.getAllReservations().stream()
                .filter(r -> r.getId().equals(reservationId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        paymentService.createPayment(reservation, payment);
        return "redirect:/payments/list";
    }
}
