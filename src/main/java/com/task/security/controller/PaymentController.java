package com.task.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.security.entity.Payment;
import com.task.security.entity.PaymentMethod;
import com.task.security.entity.Status;
import com.task.security.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @GetMapping("/health")
    public String showApiStatus() {
        return "ok";
    }

    @Autowired
    PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        try {
            payment.setStatus(Status.OPEN);
            if (payment.getMethod() == PaymentMethod.CARD) {
                return new ResponseEntity<Payment>(paymentService.savePayment(payment), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findPaymentById(@PathVariable Integer id) {
        Optional<Payment> payment = paymentService.findPaymentById(id);

        if (payment.isPresent()) {
            return new ResponseEntity<>(payment.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> findAllPayments() {
        try {
            List<Payment> payments = paymentService.findAllPayments();

            if (payments.isEmpty() || payments.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(payments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
