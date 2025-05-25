package annotation_12;

public class Main {
    public static void main(String[] args) {
        DemoController demo = new DemoController();
        // TYPE name = value;
        Processor.processAnnotation(demo);
    }
}
