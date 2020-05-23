package com.capg.pbms.loanmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.pbms.loanmanagement.dto.LoanRequestDTO;
import com.capg.pbms.loanmanagement.exception.AccountNotFoundException;
import com.capg.pbms.loanmanagement.repository.LoanRequestRepository;

public class LoanRequestServiceImpl implements LoanRequestService {
	
	@Autowired
	LoanRequestRepository requestRepository;
	
	
	@Override
	public LoanRequestDTO findById(String accountId) {
		 Optional<LoanRequestDTO> optional=requestRepository.findById(accountId);
	        if(optional.isPresent()) {
	            LoanRequestDTO loanRequest=optional.get();
	            return loanRequest;
	        }
	        throw new AccountNotFoundException("no such account exists");
	    
	}

	@Override
	public LoanRequestDTO save(LoanRequestDTO loanRequest) {
		loanRequest=requestRepository.save(loanRequest);
		return loanRequest;
	}

}
