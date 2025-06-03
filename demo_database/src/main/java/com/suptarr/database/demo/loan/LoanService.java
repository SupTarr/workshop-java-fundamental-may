package com.suptarr.database.demo.loan;

import com.suptarr.database.demo.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final PersonRepository personRepository;

    public List<Loan> getAllLoans() {
        return this.loanRepository.findAll();
    }

    public Optional<Loan> getLoanByLoanId(String loanId) {
        return this.loanRepository.findByLoanId(loanId);
    }

    public List<Loan> getLoansByPersonId(Long personId) {
        if (!this.personRepository.existsById(personId)) {
            throw new RuntimeException("Person not found with id: " + personId);
        }

        return this.loanRepository.findByPersonId(personId);
    }
}
