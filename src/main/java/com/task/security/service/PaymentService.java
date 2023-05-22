package com.task.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.security.entity.Payment;
import com.task.security.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> findPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

}
