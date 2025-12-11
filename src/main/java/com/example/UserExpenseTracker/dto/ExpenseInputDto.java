package com.example.UserExpenseTracker.dto;

import com.example.UserExpenseTracker.enums.PaymentMode;
import lombok.Data;

@Data
public class ExpenseInputDto {
    private String expenseName;
    private PaymentMode paymentMode;
    private Double amount;
}
