package com.task.security.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Status {
    OPEN,
    PROCESSING,
    APPROVED,
    REJECTED
}
