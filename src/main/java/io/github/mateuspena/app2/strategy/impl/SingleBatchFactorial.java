package io.github.mateuspena.app2.strategy.impl;

import io.github.mateuspena.app2.domain.FactorialCalculator;
import io.github.mateuspena.app2.domain.FileAccessor;
import io.github.mateuspena.app2.strategy.IBatchFactorial;

import java.io.IOException;
import java.util.List;

public class SingleBatchFactorial implements IBatchFactorial {
    @Override
    public void calculateAll(String file) throws IOException {
        FileAccessor input = new FileAccessor(file);
        FileAccessor output = new FileAccessor("output.txt");

        String[] numbers = input.readLines();
        String[] factorials = new String[ numbers.length ];
        for (int i = 0; i < numbers.length; i++) {
            factorials[i] = FactorialCalculator.calculate(numbers[i]).toString();
        }

        output.writeLines(factorials);
    }
}
