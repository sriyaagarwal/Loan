package com.capg.pbms.loanmanagement.service;

import java.util.ArrayList;
import java.util.List;

import com.capg.pbms.loanmanagement.dto.LoanDisbursal;
import com.capg.pbms.loanmanagement.dto.LoanRequestDTO;

public interface LoanDisbursalService {
LoanDisbursal findByLoanId(String id);
	 ArrayList<LoanRequestDTO> retrieveAll();
	 ArrayList<LoanDisbursal> approveLoan();
	 ArrayList<LoanDisbursal> approvedLoanList();
	 List<LoanRequestDTO> rejectedLoanRequests();
	 String updateLoanAccount(String accountId , Double amount);
	 String updateLaonStatus();
	 ArrayList<String> updateExistingbalance();
	 ArrayList<LoanDisbursal> approveLoanWithoutStatus();
}
