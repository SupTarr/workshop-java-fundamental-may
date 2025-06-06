package com.suptarr.database.demo.loan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByLoanId(String loanId);

    List<Loan> findByPersonId(Long personId);
}
