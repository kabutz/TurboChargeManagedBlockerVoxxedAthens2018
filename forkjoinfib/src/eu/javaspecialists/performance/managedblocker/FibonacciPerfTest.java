package eu.javaspecialists.performance.managedblocker;

public class FibonacciPerfTest {
    public static void main(String... args) {
        long time = System.nanoTime();
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.f(10_000_000).bitCount());
        time = System.nanoTime() - time;
        System.out.printf("test10_000_000() time = %dms%n", (time / 1_000_000));
    }
}
