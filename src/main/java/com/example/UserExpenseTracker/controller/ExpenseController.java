package com.example.UserExpenseTracker.controller;

import com.example.UserExpenseTracker.dto.ExpenseInputDto;
import com.example.UserExpenseTracker.dto.ExpenseOutputDto;
import com.example.UserExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

//    @GetMapping("/getExpense")
//    public ResponseEntity<List<ExpenseOutputDto>> getExpense(){
//        return ResponseEntity.ok(expenseService.getExpense());
//    }

    @GetMapping("/getExpense/{id}")
    public ResponseEntity<ExpenseOutputDto> getExpenseById(@PathVariable Long id){
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @PostMapping("/addExpense")
    public ResponseEntity<String> addExpense(@RequestBody ExpenseInputDto expenseInputDto){
        return ResponseEntity.ok(expenseService.addExpense(expenseInputDto));
    }

    @GetMapping("/totalExpense")
    public ResponseEntity<String> getTotalExpense(){
        return ResponseEntity.ok(expenseService.getTotalAmt());
    }
}
