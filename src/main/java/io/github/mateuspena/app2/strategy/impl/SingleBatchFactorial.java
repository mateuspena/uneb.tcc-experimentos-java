package io.github.mateuspena.app2.strategy.impl;

import io.github.mateuspena.app2.domain.FactorialCalculator;
import io.github.mateuspena.app2.domain.FileAccessor;
import io.github.mateuspena.app2.strategy.IBatchFactorial;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SingleBatchFactorial implements IBatchFactorial {
    @Override
    public void calculateAll(String file) throws IOException {
        FileAccessor input = new FileAccessor(file);
        FileAccessor output = new FileAccessor("output.txt");

        List<String> numbers = input.readLines();
        List<BigInteger> factorials = new ArrayList<>(numbers.size());
        for (String number : numbers) {
            factorials.add(FactorialCalculator.calculate(number));
        }

        output.writeLines(factorials);
    }
}
