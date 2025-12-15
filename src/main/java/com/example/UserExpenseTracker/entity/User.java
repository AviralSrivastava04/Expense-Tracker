package com.example.UserExpenseTracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private Long mobile;

    @OneToMany
    @JoinColumn(name = "user_expense")
    private Expense expense;
}
