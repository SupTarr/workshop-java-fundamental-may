class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Primitive type: do not have method to use
        float interestRate = 7.5f;
        int principal = 5;
        double interest = (interestRate / 100) * principal;
        char grade = 'A';
        boolean isPass = true;
        String name = "John Doe";

        System.out.println(interest);

        // Wrapper types: have method .floatValue()
        Integer loanTerm = 36;
        float fLoanTerm = loanTerm.floatValue();
        System.out.println(fLoanTerm);
    }
}