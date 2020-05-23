package com.capg.pbms.loanmanagement.service;

import com.capg.pbms.loanmanagement.dto.LoanRequestDTO;

public interface LoanRequestService {
	
	LoanRequestDTO findById(String accountId);
	LoanRequestDTO save(LoanRequestDTO loanRequest);
}
