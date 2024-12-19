package com.axsosacademy.savetravel.controllers;


import com.axsosacademy.savetravel.models.Expense;
import com.axsosacademy.savetravel.services.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final ExpenseService expenseService;
    public MainController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/")
    public String mainPage(
            @ModelAttribute("expense") Expense expense,
            Model model
    ) {
        model.addAttribute("expenses", expenseService.findAll());
        return "index";
    }

    @PostMapping("/addExpense")
    public String addExpense(
            @Valid @ModelAttribute("expense") Expense expense,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("expenses", expenseService.findAll());
            return "index";
        }
        else {
            expenseService.addExpense(expense);
            return "redirect:/";
        }
    }

    @GetMapping("/expenses/{id}/edit")
    public String editExpensePage(
            Model models,
            @ModelAttribute("expense") Expense editedExpense,
            @PathVariable Long id) {
        Expense expense = expenseService.getExpenseById(id);
        models.addAttribute("expense", expense);
        return "edit";
    }

    @PostMapping("/expense/makeEdit")
    public String editExpense(
            @Valid @ModelAttribute("expense") Expense expense,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "edit";
        }
        else {
            expenseService.updateExpense(expense);
            return "redirect:/";
        }

    }

    @PostMapping("/burgers/makeDelete")
    public String deleteExpense(
            @ModelAttribute("expense") Expense expense
    ) {
        expenseService.deleteExpense(expense.getId());
        return "redirect:/";
    }

    @GetMapping("/expenses/{id}")
    public String showExpensePage(
            @PathVariable Long id,
            Model model
    ) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "show";
    }


}
