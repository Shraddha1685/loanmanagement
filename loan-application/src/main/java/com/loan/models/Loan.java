package com.loan.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanId;
	private double loanAmt;
	private String loanType;
	private int duration;
	private double monthlyEMI;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)//shraddha
	@JoinColumn(name = "id", nullable = false)
	private Customer customer;

	
	
	public Loan() {

	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public double getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(double loanAmt) {
		this.loanAmt = loanAmt;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getMonthlyEMI() {
		return monthlyEMI;
	}

	public void setMonthlyEMI(double monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}
	
	@Autowired
	public Customer getCustomer() {
		return customer;
	}
	@Autowired
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanAmt=" + loanAmt + ", loanType=" + loanType + ", duration=" + duration
				+ ", monthlyEMI=" + monthlyEMI + ", customer=" + customer +  "]";
	}

}
