package com.capg.pbms.loanmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.pbms.loanmanagement.dto.LoanDisbursal;
@Repository
public interface LoanDisbursalRepository extends JpaRepository<LoanDisbursal,String>{ 

}
