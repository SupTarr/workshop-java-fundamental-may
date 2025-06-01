package abstract_08;

public class Auto extends BaseLoan implements Payment {
    public Auto(String applicantName, double loanAmount, float interestRate) {
        super(applicantName, loanAmount, interestRate);
    }

    @Override
    public double calculateInterest() {
        System.out.println("Auto:: calculateInterest() called");
        return 3.3d;
    }

    public String[] paymentOptions() {
        return new String[]{"Loan"};
    }
}
