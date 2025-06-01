package starting_point_01;

class Array {
    public static void main(String[] args) {
        String[] colours = {"Blue", "Green", "Red"};
        System.out.println("Array: " + colours.toString());
        for (String colour : colours) {
            System.out.println(colour);
        }

        int[] numbers = {1, 2, 3, 4, 5};
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.println("Even number: " + number);
            } else {
                System.out.println("Odd number: " + number);
            }
        }
    }
}