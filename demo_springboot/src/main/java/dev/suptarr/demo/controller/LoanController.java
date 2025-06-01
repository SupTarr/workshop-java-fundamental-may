package dev.suptarr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import dev.suptarr.demo.model.Loan;

@RestController
public class LoanController {

    // URI compoents
    // scheme://host:port/path/{id}?query#fragment
    // http://localhost:8080/loans/234?name=suptarr&amount=10000


    @GetMapping("/loans/{id}")
    public Loan getLoan(@PathVariable("id") String id) {
        System.out.println("Path id: " + id);

        Loan loan = new Loan();
        loan.setLoanId("L001");
        loan.setApplicantName("Laumcing");
        loan.setLoanAmount(1000000);
        loan.setLoanTerm(12);
        loan.setStatus("Approved");
        loan.setInterestRate(7.5);

        return loan;
    }
}
