package com.capg.pbms.loanmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.pbms.loanmanagement.dto.LoanDisburalDTO;
import com.capg.pbms.loanmanagement.dto.LoanDisbursal;
import com.capg.pbms.loanmanagement.dto.LoanRequestDTO;
import com.capg.pbms.loanmanagement.dto.LoanRequestDetailsDTO;
import com.capg.pbms.loanmanagement.service.LoanDisbursalService;

@RestController
@RequestMapping("/loanDisbursal")
public class LoanDisbursalController {
	

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoanDisbursalService service;
	
	
	
	
	@GetMapping("/loanDisbursal/retiveAll")
	public ResponseEntity<List<LoanRequestDetailsDTO>> fetchAll()
	{
		 List<LoanRequestDTO> loanRequest = service.retrieveAll();
		 List<LoanRequestDetailsDTO> list = convertLoanRequestDetailsDto(loanRequest);
		 ResponseEntity<List<LoanRequestDetailsDTO>> response = new ResponseEntity<>(list,HttpStatus.OK);
		 return response;
	}
	 
	
	
	@GetMapping("/loanDisbursal/aproveLoan")
	public ResponseEntity<List<LoanDisburalDTO>> approveLoan()
	{
		List<LoanDisbursal> loanDisbursal= service.approveLoan();
		List<LoanDisburalDTO>  list= convertLoanDisbursalDetailsDto(loanDisbursal);
		ResponseEntity<List<LoanDisburalDTO>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/get/{id}")
    public ResponseEntity<LoanDisburalDTO>  add(@PathVariable("id") String id) {
        LoanDisbursal loanDisbursal = service.findByLoanId(id);
        LoanDisburalDTO dto = convertLoanDisbursalDto(loanDisbursal);
        ResponseEntity<LoanDisburalDTO> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
    }
	
	
	
	@GetMapping("/loanDisbursal/approvedLoanList")
	public ResponseEntity<List<LoanDisburalDTO>> getApprovedList()
	{
		List<LoanDisbursal>  loanDisbursal = service.approvedLoanList();
		List<LoanDisburalDTO> list = convertLoanDisbursalDetailsDto(loanDisbursal);
		ResponseEntity<List<LoanDisburalDTO>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}
	
	
	
	@GetMapping("/loanDisbursal/rejectedList")
	public ResponseEntity<List<LoanRequestDetailsDTO>> getRejectedList()
	{
		List<LoanRequestDTO> loanDisbursal = service.rejectedLoanRequests();
		List<LoanRequestDetailsDTO> list = convertLoanRequestDetailsDto(loanDisbursal);
		ResponseEntity<List<LoanRequestDetailsDTO>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response;
		
	}
	
	private List<LoanRequestDetailsDTO> convertLoanRequestDetailsDto(List<LoanRequestDTO> loanDisbursal)
	{
		List<LoanRequestDetailsDTO> list = new ArrayList();
		for(LoanRequestDTO obj: loanDisbursal)
		{
			LoanRequestDetailsDTO details = convertLoanRequestDto(obj);
			list.add(details);
			
		}
		return list;
	}
		
	
	
	
	public LoanRequestDetailsDTO convertLoanRequestDto(LoanRequestDTO loanRequest)
	{
		LoanRequestDetailsDTO dto = new LoanRequestDetailsDTO();
		dto.setLoanId(loanRequest.getLoanId());
		dto.setAccountId(loanRequest.getAccountId());
		dto.setLoanAmount(loanRequest.getLoanAmount());
		dto.setLoanType(loanRequest.getLoanType());
		dto.setLoanTenure(loanRequest.getLoanTenure());
		dto.setLoanRoi(loanRequest.getloanRoi());
		dto.setLoanStatus(loanRequest.getLoanStatus());
		dto.setCreditScore(loanRequest.getCreditScore());
		
		return dto;
		
	}
	
	
	private List<LoanDisburalDTO> convertLoanDisbursalDetailsDto(List<LoanDisbursal> loanDisbursal)
	{
		List<LoanDisburalDTO> list = new ArrayList();
		for(LoanDisbursal obj: loanDisbursal)
		{
			LoanDisburalDTO details = convertLoanDisbursalDto(obj);
			list.add(details);
			
		}
		return list;
	}
	
	public LoanDisburalDTO convertLoanDisbursalDto(LoanDisbursal loanDisbursal)
	{
		LoanDisburalDTO dto = new LoanDisburalDTO();
		dto.setLoanRequestId(loanDisbursal.getLoanRequestId());
		dto.setLoanCustomerId(loanDisbursal.getAccountId());
		dto.setLoanAmount(loanDisbursal.getLoanAmount());
		dto.setLoanType(loanDisbursal.getLoanType());
		dto.setLoanTenure(loanDisbursal.getLoanTenure());
		return dto;
	}
	
	
	
	
	
	

}
