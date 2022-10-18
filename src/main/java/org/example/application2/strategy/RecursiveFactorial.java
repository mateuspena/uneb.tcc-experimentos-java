package org.example.application2.strategy;

import java.math.BigInteger;
import java.util.List;

public class RecursiveFactorial implements IFactorial {

    @Override
    public List<BigInteger> calculateAll(List<BigInteger> numbers) {
        return null;
    }

    @Override
    public BigInteger calculate(BigInteger number) {
        return number.compareTo(BigInteger.ONE) < 1
                ? BigInteger.ONE
                : number.multiply(calculate(number.subtract(BigInteger.ONE)));
    }
}
