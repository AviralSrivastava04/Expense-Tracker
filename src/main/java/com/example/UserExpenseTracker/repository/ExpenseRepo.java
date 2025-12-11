package com.example.UserExpenseTracker.repository;

import com.example.UserExpenseTracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {
}
