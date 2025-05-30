package com.suptarr.database.demo.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loans/")
    public List<Loan> getLoans() {
        return this.loanService.getAllLoans();
    }

    @GetMapping("/loans/{loanId}")
    public Loan getLoan(@PathVariable("loanId") String loanId) {
        Optional<Loan> loanOptional = this.loanService.getLoanByLoanId(loanId);
        return loanOptional.orElseThrow(() -> new RuntimeException("Loan not found with loan id: " + loanId));
    }
}
