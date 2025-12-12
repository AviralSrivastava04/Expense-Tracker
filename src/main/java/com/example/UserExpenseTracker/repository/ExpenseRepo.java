package com.example.UserExpenseTracker.repository;

import com.example.UserExpenseTracker.entity.Expense;
import com.example.UserExpenseTracker.enums.PaymentMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    List<Expense> findByPaymentMode(PaymentMode paymentMode);
}
