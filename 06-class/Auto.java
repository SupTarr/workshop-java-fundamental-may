public class Auto extends Loan {
    // Default constructor
    public Auto() {
        super();
    } 

    // Constructor with parameters
    public Auto(String applicantName, double loanAmount, float interestRate) {
        super(applicantName, loanAmount, interestRate);
    } 

    @Override
    public String toString() {
        return "(Auto) " + super.toString();
    }
    
}
