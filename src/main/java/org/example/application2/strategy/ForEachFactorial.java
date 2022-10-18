package org.example.application2.strategy;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForEachFactorial implements IFactorial {

    @Override
    public List<BigInteger> calculateAll(List<BigInteger> numbers) {
        List<BigInteger> factorials = new ArrayList<>(numbers.size());
        for (BigInteger number : numbers) {
            factorials.add(calculate(number));
        }

        return factorials;
    }

    @Override
    public BigInteger calculate(BigInteger number) {
        List<Integer> numbers = new ArrayList<>(IntStream.rangeClosed(1, number.intValue()).boxed().toList());

        BigInteger f = BigInteger.ONE;
        for (Integer n : numbers) {
            f = f.multiply(BigInteger.valueOf(n));
        }

        return f;
    }
}
