package com.capg.pbms.loanmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.pbms.loanmanagement.dto.LoanRequestDTO;
@Repository
public interface LoanRequestRepository extends JpaRepository<LoanRequestDTO,String>{

}
