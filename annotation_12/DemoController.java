package annotation_12;

public class DemoController {

    @GetMapping
    public void getAllLoan() {
        System.out.println("DemoController:: getAllLoan()");
    }

    @PostMapping("/loans")
    public void insertLoan() {
        System.out.println("DemoController:: insertLoan()");
    }
}
