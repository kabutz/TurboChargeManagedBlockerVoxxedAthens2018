package eu.javaspecialists.performance.managedblocker;

import java.math.*;
import java.util.concurrent.*;

// test100_000_000() time = 37729
// test100_000_000() time = 21393
// test100_000_000() time = 16108

// TODO: Sign up to Heinz's Newsletter: www.javaspecialists.eu
public class Fibonacci {
    public BigInteger f(int n) {
        if (n < 0) throw new IllegalArgumentException("n < 0");
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        int half = (n + 1) / 2;

        RecursiveTask<BigInteger> f0task = new RecursiveTask<BigInteger>() {
            protected BigInteger compute() {
                return f(half-1);
            }
        };
        f0task.fork();
        BigInteger f1 = f(half);
        BigInteger f0 = f0task.join();

        if (n % 2 == 1) {
            return f0.multiply(f0).add(f1.multiply(f1));
        } else {
            return f0.shiftLeft(1).add(f1).multiply(f1);
        }
    }
}
