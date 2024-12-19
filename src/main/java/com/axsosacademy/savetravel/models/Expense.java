package com.axsosacademy.savetravel.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Name must be between 3 - 50")
    private String expenseName;

    @NotBlank(message = "Description must not be empty")
    private String description;

    @NotNull
    @Size(min = 3, max = 100, message = "Vendor must be between 3 - 100")
    private String vendor;

    @NotNull
    @DecimalMin(value = "0.0", message = "Amount must be positive")
    private Double amount;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    // Constructors
    public Expense() {
    }

    public Expense(String expense, String description, String vendor, Double amount) {
        this.expenseName = expense;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    // Setters

    public void setExpenseName(String expense) {
        this.expenseName = expense;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
