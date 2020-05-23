package com.capg.pbms.loanmanagement.dto;



import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;
@Entity
public class LoanRequestDTO {
	
	@Id
	@NotNull
	@Column(length=12)
	private String loanId;
	private String accountId;
    private Double loanAmount;
    private int loanTenure;

	private Double loanRoi=8.0d;
	
	private String loanStatus="pending";
	
	private String loanType;
	
	private int creditScore;
	
	
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public Double getLoanRoi() {
		return loanRoi;
	}
	public void setLoanRoi(Double loanRoi) {
		this.loanRoi = loanRoi;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public int getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}
	public Double getloanRoi() {
		return loanRoi;
	}
	public void setRoi(Double loanRoi) {
		this.loanRoi = loanRoi;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	
	

	 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanRequestDTO customer = (LoanRequestDTO) o;
       return accountId == customer.accountId;
    }

    @Override
    public int hashCode() {
	        return Objects.hash(accountId);
   }

}
