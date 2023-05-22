package com.task.security.request;

import com.task.security.entity.PaymentMethod;

import ch.qos.logback.core.status.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private String customer_name;
    private Integer amount;
    private PaymentMethod method;
    private Status status;
}
