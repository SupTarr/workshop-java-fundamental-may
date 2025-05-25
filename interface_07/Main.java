package interface_07;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------");

        Loan laumcing = new Auto("Laumcing", 330000.0d, 2.5f);
        System.out.println(laumcing.calculateInterest());
        System.out.println(laumcing);

        System.out.println("--------------------");
        Mortgage jenny = new Mortgage("Jenny", 20000.0d, 8.5f);
        System.out.println(jenny.calculateInterest());
        System.out.println(jenny);

    }
}
