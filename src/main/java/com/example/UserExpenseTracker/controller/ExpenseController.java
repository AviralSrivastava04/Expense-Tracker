package com.example.UserExpenseTracker.controller;

import com.example.UserExpenseTracker.dto.ExpenseOutputDto;
import com.example.UserExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/getExpense")
    public ResponseEntity<List<ExpenseOutputDto>> getExpense(){
        return ResponseEntity.ok(expenseService.getExpense());
    }
}
