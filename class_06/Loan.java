package class_06;

public class Loan {
    protected static int x = 3;
    // OOP: Encapsulation -> private
    private String applicantName;
    private double loanAmount;
    private float interestRate;

    // OOP: Overloading -> Loan()
    // Default constructor
    public Loan() {
        this.applicantName = "";
        this.loanAmount = 0;
        this.interestRate = 0;
    }

    // Constructor with parameters
    public Loan(String applicantName, double loanAmount, float interestRate) {
        this.applicantName = applicantName;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    public static void announceLoan() {
        System.out.println("Loan announced");
    }

    public static void main(String[] args) {
        Loan loan = new Loan();
        loan.applicantName = "John Doe";
    }

    // Getter
    public String getApplicantName() {
        return applicantName;
    }

    // Setter
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public String toString() {
        return "(Loan) applicantName: " + applicantName + "\n" +
                "(Loan) loanAmount: " + loanAmount + "\n" +
                "(Loan) interestRate: " + interestRate;
    }
}
