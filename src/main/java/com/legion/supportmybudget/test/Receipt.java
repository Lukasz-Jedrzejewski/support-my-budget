package com.legion.supportmybudget.test;

import java.time.LocalDateTime;
import java.util.UUID;

public class Receipt {

    private UUID id = UUID.randomUUID();
    private LocalDateTime creation_date = LocalDateTime.now();
    private LocalDateTime update_date = LocalDateTime.now();
    private boolean removed = false;
    private double sum;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
