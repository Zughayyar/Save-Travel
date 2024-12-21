package com.axsosacademy.savetravel.services;

import com.axsosacademy.savetravel.models.Expense;
import com.axsosacademy.savetravel.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Return All
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    // Get By id
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    // Add Expense
    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    // Update Expense
    public void updateExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    // Delete Expense
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
