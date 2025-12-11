package com.example.UserExpenseTracker.service;

import com.example.UserExpenseTracker.dto.ExpenseOutputDto;
import com.example.UserExpenseTracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepo;

    public List<ExpenseOutputDto> getExpense() {
    }
}
