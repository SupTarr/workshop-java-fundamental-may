package part07;

public class Auto implements Loan {
    // Constructor with parameters
    public Auto(String applicantName, double loanAmount, float interestRate) {
    }

    @Override
    public double calculateInterest() {
        return 4.4;
    }
}
