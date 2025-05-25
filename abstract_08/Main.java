package abstract_08;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Auto laumcing = new Auto("Laumcing", 10000.0d, 7.5f);
        System.out.println(laumcing.getInterestRate());
        System.out.println(laumcing.getLoanAmount());
        System.out.println(laumcing.getApplicantName());
        System.out.println(laumcing.calculateInterest());
        System.out.println(Arrays.toString(laumcing.paymentOptions()));
    }
}