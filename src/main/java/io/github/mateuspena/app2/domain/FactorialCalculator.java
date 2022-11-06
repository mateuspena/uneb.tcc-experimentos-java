package io.github.mateuspena.app2.domain;

import java.math.BigInteger;

public abstract class FactorialCalculator {

    public static BigInteger calculate(String number) {
        return calculate(Long.parseLong(number));
    }

    public static BigInteger calculate(int number) {
        return calculate((long) number);
    }

    public static BigInteger calculate(long number) {
        return calculate(BigInteger.valueOf(number));
    }

    public static BigInteger calculate(BigInteger number) {
        BigInteger bigOne = BigInteger.ONE;

        BigInteger f = bigOne;
        for (BigInteger n = number;
             n.compareTo(bigOne) > 0;
             n = n.subtract(bigOne))
            f = f.multiply(n);

        return f;
    }
}
