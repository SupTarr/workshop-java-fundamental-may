package com.suptarr.database.demo.loan;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.suptarr.database.demo.person.PersonRepository;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final PersonRepository personRepository;

    public LoanService(LoanRepository loanRepository, PersonRepository personRepository) {
        this.loanRepository = loanRepository;
        this.personRepository = personRepository;
    }

    public List<Loan> getAllLoans() {
        return this.loanRepository.findAll();
    }

    public Optional<Loan> getLoanByLoanId(String loanId) {
        return this.loanRepository.findByLoanId(loanId);
    }

    public List<Loan> getLoansByPersonId(Long personId) {
        return personRepository.findById(personId)
                .map(person -> person.getLoans().stream().collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + personId));
    }
}
