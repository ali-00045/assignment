package com.task.security.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PaymentMethod {
    CARD,
    BANKTRANSFER,
    PAYPAL,
    OTHERS
}
