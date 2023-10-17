package com.loan.services;

import java.util.List;

import com.loan.models.Loan;

public interface iLoanService {

	public Loan applyLoan(Loan l);

	public List<Loan> getLoansByCustomerId(int custId); //shraddha

	public void foreCloseLoan(int loanId);

}
