package com.example.UserExpenseTracker.service;

import com.example.UserExpenseTracker.dto.ExpenseInputDto;
import com.example.UserExpenseTracker.dto.ExpenseOutputDto;
import com.example.UserExpenseTracker.entity.Expense;
import com.example.UserExpenseTracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepo;

    public String getTotalAmt() {
        List<Expense> expenseList = expenseRepo.findAll();
        Double totalAmt = 0.0;
        for(Expense expense : expenseList){
            totalAmt = totalAmt + expense.getAmount();
        }
        return "Rs." + totalAmt;
    }

    public ExpenseOutputDto getExpenseById(Long id){
        Expense expense = expenseRepo.findById(id).orElse(null);
        ExpenseOutputDto expenseOutputDto = new ExpenseOutputDto();
        expenseOutputDto.setExpenseName(expense.getExpenseName());
        expenseOutputDto.setPaymentMode(expense.getPaymentMode());
        expenseOutputDto.setId(expense.getId());
        expenseOutputDto.setDate(expense.getDate());
        expenseOutputDto.setAmount(expense.getAmount());

        return expenseOutputDto;
    }

    public String addExpense(ExpenseInputDto expenseInputDto){
        Expense expense = new Expense();
        expense.setExpenseName(expenseInputDto.getExpenseName());
        expense.setDate(LocalDate.now());
        expense.setAmount(expenseInputDto.getAmount());
        expense.setPaymentMode(expenseInputDto.getPaymentMode());

        expenseRepo.save(expense);
        return "Expense Added!!!";
    }
}
