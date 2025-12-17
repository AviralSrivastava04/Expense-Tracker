package com.example.UserExpenseTracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String mobile;

    @OneToMany(mappedBy = "user")
    private List<Expense> expenseList;

    public User(String username, String mobile) {
        this.userName = username;
        this.mobile = mobile;
    }
}
