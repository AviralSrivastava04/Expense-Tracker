package com.example.UserExpenseTracker.service;

import com.example.UserExpenseTracker.dto.ExpenseInputDto;
import com.example.UserExpenseTracker.dto.ExpenseOutputDto;
import com.example.UserExpenseTracker.dto.UserInputDto;
import com.example.UserExpenseTracker.entity.Expense;
import com.example.UserExpenseTracker.entity.User;
import com.example.UserExpenseTracker.enums.PaymentMode;
import com.example.UserExpenseTracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
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
        expense.setUser(new User(expenseInputDto.getUsername(), expenseInputDto.getMobile()));
        expense.setExpenseName(expenseInputDto.getExpenseName());
        expense.setDate(LocalDate.now());
        expense.setAmount(expenseInputDto.getAmount());
        expense.setPaymentMode(expenseInputDto.getPaymentMode());

        expenseRepo.save(expense);
        return "Expense Added!!!";
    }

    public List<ExpenseOutputDto> getExpenseByPaymentMode(String paymentMode){
        List<Expense> expenseList = expenseRepo.findByPaymentMode(PaymentMode.valueOf(paymentMode));
        List<ExpenseOutputDto> expenseOutputDtoList = new ArrayList<>();
        for(Expense expense : expenseList){
            ExpenseOutputDto expenseOutputDto = new ExpenseOutputDto();
            expenseOutputDto.setExpenseName(expense.getExpenseName());
            expenseOutputDto.setPaymentMode(expense.getPaymentMode());
            expenseOutputDto.setId(expense.getId());
            expenseOutputDto.setDate(expense.getDate());
            expenseOutputDto.setAmount(expense.getAmount());

            expenseOutputDtoList.add(expenseOutputDto);
        }
        return expenseOutputDtoList;
    }

    public List<ExpenseOutputDto> getByAmtRange(Double minAmt, Double maxAmt) {
        List<Expense> expenseList = expenseRepo.findByAmountBetween(minAmt, maxAmt);
        List<ExpenseOutputDto> expenseOutputDtoList = new ArrayList<>();
        for(Expense expense : expenseList){
            ExpenseOutputDto expenseOutputDto = new ExpenseOutputDto();
            expenseOutputDto.setExpenseName(expense.getExpenseName());
            expenseOutputDto.setId(expense.getId());
            expenseOutputDto.setPaymentMode(expense.getPaymentMode());
            expenseOutputDto.setDate(expense.getDate());
            expenseOutputDto.setAmount(expense.getAmount());

            expenseOutputDtoList.add(expenseOutputDto);
        }

        return expenseOutputDtoList;
    }
}























