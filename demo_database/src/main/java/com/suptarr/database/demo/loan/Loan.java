package com.suptarr.database.demo.loan;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    private Long id;

    private String loanId;
    private String applicantName;
    private double loanAmount;
    private int loanTerm;
    private String status;
    private double interestRate;
}