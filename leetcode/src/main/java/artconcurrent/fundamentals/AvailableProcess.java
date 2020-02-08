package artconcurrent.fundamentals;

public class AvailableProcess {
    public static void main(String[] args) {
        int counter =Runtime.getRuntime().availableProcessors();
        System.out.println(counter);
    }
}
