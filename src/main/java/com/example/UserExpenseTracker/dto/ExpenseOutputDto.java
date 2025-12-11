package com.example.UserExpenseTracker.dto;

import com.example.UserExpenseTracker.enums.PaymentMode;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseOutputDto {
    private Long id;
    private String expenseName;
    private LocalDate date;
    private PaymentMode paymentMode;
    private Double amount;
}
