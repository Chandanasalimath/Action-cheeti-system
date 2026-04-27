package com.actioncheeti.actioncheeti;

import jakarta.persistence.*;

@Entity
public class CheetiMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long cheetiId;
    @Column(name = "month_no")
    private int month;
    private boolean hasPaid = false;
    private boolean hasWon = false;
    private double bidAmount = 0;


    // ✅ IMPORTANT: default constructor
    public CheetiMember() {}

    // getters & setters

    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCheetiId() { return cheetiId; }
    public void setCheetiId(Long cheetiId) { this.cheetiId = cheetiId; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public boolean isHasPaid() { return hasPaid; }
    public void setHasPaid(boolean hasPaid) { this.hasPaid = hasPaid; }

    public boolean isHasWon() { return hasWon; }
    public void setHasWon(boolean hasWon) { this.hasWon = hasWon; }

    public double getBidAmount() { return bidAmount; }
    public void setBidAmount(double bidAmount) { this.bidAmount = bidAmount; }
}