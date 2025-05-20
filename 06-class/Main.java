public class Main {
    public static void main(String[] args) {
        Loan loan1 = new Loan();
        loan1.setApplicantName("Lamching");
        System.out.println("Applicant Name: " + loan1.getApplicantName());
        System.out.println("Loan Amount: " + loan1.getLoanAmount());
        System.out.println("Interes Rate: " + loan1.getInterestRate());

        Loan loan2 = new Loan("Chaiyo", 100000, 7.5f);
        System.out.println("Applicant Name: " + loan2.getApplicantName());
        System.out.println("Loan Amount: " + loan2.getLoanAmount());
        System.out.println("Interes Rate: " + loan2.getInterestRate());

        Mortgage mortage1 = new Mortgage("Krungthai", 1000000, 5f);
        System.out.println("Applicant Name: " + mortage1.getApplicantName());
        System.out.println("Loan Amount: " + mortage1.getLoanAmount());
        System.out.println("Interes Rate: " + mortage1.getInterestRate());

        Auto auto1 = new Auto("Krungsri", 2000000, 5f);
        System.out.println(auto1);
    }
}