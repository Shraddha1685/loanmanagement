package com.loan.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.loan.dao.CustomerRepository;
import com.loan.dao.LoanRepository;
import com.loan.exceptions.CustomerNotFoundException;
import com.loan.exceptions.LoanNotFoundException;
import com.loan.models.Customer;
import com.loan.models.Loan;
import com.loan.services.iLoanService;

@Service
@Primary
public class LoanServiceImpl implements iLoanService {

	@Autowired
	private LoanRepository loanDao;

	@Autowired
	private CustomerRepository customerDao;

	private Logger logger = Logger.getLogger(getClass());

	public Loan applyLoan(Loan loan) {
		int customerId = loan.getCustomer().getId();
		System.out.println("customerId "+customerId);
		Customer customer = customerDao.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Cusotmer Not Found: " + customerId));
		//customer.addLoan(loan); //shraddha
		System.out.println("before loan "+loan);
		loan.setCustomer(customer);
		System.out.println("after loan "+loan);
		return loanDao.save(loan);
	}
	
	
	@Override
	public List<Loan> getLoansByCustomerId(int customerId) {
		
		//return customer.getLoans();//shraddha
		
		
		
		Customer customer = customerDao.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer Not Found: " + customerId));
		    List<Loan> loans = loanDao.findByCustomerId(customerId);//shraddha
		    return loans;//shraddha
			//return customer.getLoans();	
	}

	@Override
	public void foreCloseLoan(int loanId) {
		Loan loan = loanDao.findById(loanId).orElseThrow(() -> new LoanNotFoundException("Loan Not Found: " + loanId));
		loanDao.delete(loan);
	}

}
