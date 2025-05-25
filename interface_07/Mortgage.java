package interface_07;

public class Mortgage implements Loan {
    // Constructor with parameters
    public Mortgage(String applicantName, double loanAmount, float interestRate) {
    }

    @Override
    public double calculateInterest() {
        return 3.5;
    }
}
