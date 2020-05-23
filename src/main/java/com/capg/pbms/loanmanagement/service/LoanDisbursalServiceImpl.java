package com.capg.pbms.loanmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.pbms.loanmanagement.dto.LoanDisburalDTO;
import com.capg.pbms.loanmanagement.dto.LoanDisbursal;
import com.capg.pbms.loanmanagement.dto.LoanRequestDTO;
import com.capg.pbms.loanmanagement.exception.AccountNotFoundException;
import com.capg.pbms.loanmanagement.repository.LoanDisbursalRepository;
import com.capg.pbms.loanmanagement.repository.LoanRequestRepository;

@Service
public class LoanDisbursalServiceImpl implements LoanDisbursalService {
		
		@Autowired
		LoanDisbursalRepository disbursalRepository;
		
		@Autowired
	    LoanRequestRepository requestRepository;
	
	
		@Override
		public LoanDisbursal findByLoanId(String id) {
			Optional<LoanDisbursal> optional = disbursalRepository.findById(id);
			if(optional.isPresent())
			{
				LoanDisbursal loanDisbursal = optional.get();
				return loanDisbursal;
			}
			throw new AccountNotFoundException("no such data exist");
		}
		
		
		@Override
		public ArrayList<LoanRequestDTO> retrieveAll() {
		
			return (ArrayList<LoanRequestDTO>) requestRepository.findAll();
		}

		
		@Override
		public ArrayList<LoanDisbursal> approveLoan() {
			List<LoanRequestDTO> list = requestRepository.findAll();
			
					
		    
		    for(LoanRequestDTO obj: list)
		    {
		    	if((obj.getCreditScore()>=670))
		    			{
		    		LoanDisbursal Loan= new LoanDisbursal();
		    		Loan.setLoanRequestId(obj.getLoanId());
		    		Loan.setAccountId(obj.getAccountId());
		    		Loan.setLoanAmount(obj.getLoanAmount());    		
		    		Loan.setLoanTenure(obj.getLoanTenure());
		    		Loan.setLoan_amount_paid(0);
		    		Loan.setLoan_due_date(null);
					
					if(obj.getLoanType().equals("Home"))
					{
						obj.setLoanRoi(8.5);
						Loan.setLoanType("home");
					}
					else if(obj.getLoanType().equals("Education"))
					{
						obj.setLoanRoi(7.5);
						Loan.setLoanType("education");
						}
					else if(obj.getLoanType().equals("Personal"))
					{
						obj.setLoanRoi(8.5);
						Loan.setLoanType("personal");
					}
					else
					{
						obj.setLoanRoi(12.5);
						Loan.setLoanType("other");
					}
		    	   	double interest = (obj.getLoanAmount()*obj.getloanRoi()*obj.getLoanTenure())/(12*100);
		    		double emi = (obj.getLoanAmount()+interest)/obj.getLoanTenure();
		    		Loan.setloanEmi(emi);
		    		
		    		obj.setLoanStatus("accepted");
		    		disbursalRepository.save(Loan);
		    		
		    	}
		    	  obj.setLoanStatus("rejected");
		    	
		    }
		    	
		    		
		    		return (ArrayList<LoanDisbursal>) disbursalRepository.findAll();
		    }
		
		

		@Override
		public ArrayList<LoanRequestDTO> rejectedLoanRequests() {
			List<LoanRequestDTO> list = requestRepository.findAll();
			List<LoanRequestDTO> list2 = null;
			
			for(LoanRequestDTO loanRequest: list )
			{
				if(loanRequest.getLoanStatus().equals("rejected"))
				{
					list2.add(loanRequest);				
				}
				
			}
			return (ArrayList<LoanRequestDTO>) list2;
		}
		
		

		@Override
		public ArrayList<LoanDisbursal> approvedLoanList() {
			List<LoanDisbursal> list = disbursalRepository.findAll();
			
			return (ArrayList<LoanDisbursal>) list;
		}
		
		
		
		@Override
		public String updateLoanAccount(String accountId,Double amount) {
			
			    Optional<LoanDisbursal> optional=disbursalRepository.findById(accountId);
		        if(optional.isPresent()) {
		        	LoanDisbursal Loan= new LoanDisbursal();
		        	Loan=optional.get();
		        	Loan.setLoan_amount_paid(Loan.getLoan_amount_paid()+amount);
		        	Loan.setLoanTenure(Loan.getLoanTenure()-1);
		            
		            
		        }
			
			
			return "updated";
		}
		


		@Override
		public String updateLaonStatus() {
			
			return null;
		}

		@Override
		public ArrayList<String> updateExistingbalance() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<LoanDisbursal> approveLoanWithoutStatus() {
			// TODO Auto-generated method stub
			return null;
		}




}
