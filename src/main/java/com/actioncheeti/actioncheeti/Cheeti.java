package com.actioncheeti.actioncheeti;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Cheeti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int totalMembers;
    private double monthlyAmount;
    private int duration;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalMembers() {
		return totalMembers;
	}
	public void setTotalMembers(int totalMembers) {
		this.totalMembers = totalMembers;
	}
	public double getMonthlyAmount() {
		return monthlyAmount;
	}
	public void setMonthlyAmount(double monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

    // getters and setters
}