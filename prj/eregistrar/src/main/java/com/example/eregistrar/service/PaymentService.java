package com.example.eregistrar.service;

import com.example.eregistrar.model.Payment;
import com.example.eregistrar.model.Reservation;
import com.example.eregistrar.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment createPayment(Reservation reservation, Payment payment) {
        payment.setReservation(reservation);
        payment.setStatus("PAID");
        return paymentRepository.save(payment);
    }
}
