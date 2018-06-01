package eu.javaspecialists.performance.managedblocker;

import org.junit.*;

import java.util.concurrent.*;

import static org.junit.Assert.*;

/*
 JVM parameters: -Xbootclasspath/p:/Users/heinz/Dropbox/heinz/projects/talks/18_VoxxedAthens/TurboChargeManagedBlockerVoxxedAthens2018/out/production/mathhack -Djava.util.concurrent.ForkJoinPool.common.parallelism=0 -ea -verbose:gc -Xmx8g -Xms8g -XX:NewSize=4g -XX:SurvivorRatio=1
  */
public class FibonacciTest {
    @Test
    public void testNegativeValues() {
        Fibonacci fib = new Fibonacci();
        try {
            fib.f(-1);
        } catch (IllegalArgumentException success) {}
        try {
            fib.f(-100);
        } catch (IllegalArgumentException success) {}
        try {
            fib.f(-1_000_000);
        } catch (IllegalArgumentException success) {}

    }

    @Test
    public void testSimpleValues() {
        Fibonacci fib = new Fibonacci();
        assertEquals("0", fib.f(0).toString());
        assertEquals("1", fib.f(1).toString());
        assertEquals("1", fib.f(2).toString());
        assertEquals("2", fib.f(3).toString());
        assertEquals("3", fib.f(4).toString());
        assertEquals("5", fib.f(5).toString());
        assertEquals("8", fib.f(6).toString());
        assertEquals("13", fib.f(7).toString());
        assertEquals("21", fib.f(8).toString());
        assertEquals("34", fib.f(9).toString());
        assertEquals("55", fib.f(10).toString());
        assertEquals("89", fib.f(11).toString());
    }

    @Test
    public void test1_000() {
        long time = System.nanoTime();
        Fibonacci fib = new Fibonacci();
        assertEquals(324, fib.f(1_000).bitCount());
        time = System.nanoTime() - time;
        System.out.printf("test1_000() time = %dms%n", (time / 1_000_000));
    }

    //@Test
    public void test1_000_000() {
        long time = System.nanoTime();
        System.out.println("Before test1_000_000(): " + ForkJoinPool.commonPool());
        Fibonacci fib = new Fibonacci();
        assertEquals(347084, fib.f(1_000_000).bitCount());
        time = System.nanoTime() - time;
        System.out.printf("test1_000_000() time = %dms%n", (time / 1_000_000));
        System.out.println("Before test1_000_000(): " + ForkJoinPool.commonPool());
    }

    //@Test
    public void test10_000_000() {
        long time = System.nanoTime();
        Fibonacci fib = new Fibonacci();
        assertEquals(3471105, fib.f(10_000_000).bitCount());
        time = System.nanoTime() - time;
        System.out.printf("test10_000_000() time = %dms%n", (time / 1_000_000));
    }

    @Test
    public void test100_000_000() {
        System.out.println("Before test100_000_000(): " + ForkJoinPool.commonPool());
        long time = System.nanoTime();
        Fibonacci fib = new Fibonacci();
        assertEquals(34712631, fib.f(100_000_000).bitCount());
        time = System.nanoTime() - time;
        System.out.printf("test100_000_000() time = %dms%n", (time / 1_000_000));
        System.out.println("After test100_000_000(): " + ForkJoinPool.commonPool());
    }

    //@Test
    public void test250_000_000() {
        long time = System.nanoTime();
        Fibonacci fib = new Fibonacci();
        assertEquals(86782146, fib.f(250_000_000).bitCount());
        time = System.nanoTime() - time;
        System.out.printf("test250_000_000() time = %dms%n", (time / 1_000_000));
    }
}
