package com.suptarr.database.demo.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/loans")
    public ResponseEntity<List<Loan>> getLoans() {
        return ResponseEntity.ok(this.loanService.getAllLoans());
    }

    @GetMapping("/loans/{loanId}")
    public ResponseEntity<Loan> getLoan(@PathVariable("loanId") String loanId) {
        Optional<Loan> loanOptional = this.loanService.getLoanByLoanId(loanId);
        return loanOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/loans/persons/{personId}")
    public ResponseEntity<List<Loan>> getLoansByPersonId(@PathVariable("personId") Long personId) {
        try {
            List<Loan> loans = this.loanService.getLoansByPersonId(personId);
            return ResponseEntity.ok(loans);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
