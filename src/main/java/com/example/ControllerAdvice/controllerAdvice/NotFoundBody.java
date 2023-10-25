package com.example.ControllerAdvice.controllerAdvice;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotFoundBody {
    public String reason;
    public String errorId;
    public LocalDateTime currentDateTime;
    public NotFoundBody(String reason, String errorId, LocalDateTime currentDateTime) {
        this.reason = reason;
        this.errorId = errorId;
        this.currentDateTime = currentDateTime;
    }
}
