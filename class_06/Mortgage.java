package class_06;

public class Mortgage extends Loan {
    // Default constructor
    public Mortgage() {
        super();
    } 

    // Constructor with parameters
    public Mortgage(String applicantName, double loanAmount, float interestRate) {
        super(applicantName, loanAmount, interestRate);
    } 
}
