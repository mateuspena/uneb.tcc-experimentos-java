package org.example.application2.strategy;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ForClassicFactorial implements IFactorial {

    @Override
    public List<BigInteger> calculateAll(List<BigInteger> numbers) {
        int size = numbers.size();
        List<BigInteger> factorials = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            factorials.add(calculate(numbers.get(i)));
        }

        return factorials;
    }

    @Override
    public BigInteger calculate(BigInteger number) {
        BigInteger f = BigInteger.ONE;
        for (BigInteger m = number; m.compareTo(BigInteger.ONE) > 0; m = m.subtract(BigInteger.ONE))
            f = f.multiply(m);

        return f;
    }
}
