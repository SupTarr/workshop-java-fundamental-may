-- LoanLoan: {"loanId": "L001","applicantName": "Laumcing","loanAmount": 10000,"loanTerm": 12,"status": "APPROVED","interestRate": 7.5}
INSERT INTO loan (loan_id, person_id, applicant_name, loan_amount, loan_term, status, interest_rate)
VALUES ('L001', 1, 'Laumcing', 10000.00, 12, 'APPROVED', 7.50) ON CONFLICT (loan_id) DO NOTHING;

INSERT INTO loan (loan_id, person_id, applicant_name, loan_amount, loan_term, status, interest_rate)
VALUES ('L002', 2, 'Zothanmawia', 15000.00, 24, 'PENDING', 6.50) ON CONFLICT (loan_id) DO NOTHING;