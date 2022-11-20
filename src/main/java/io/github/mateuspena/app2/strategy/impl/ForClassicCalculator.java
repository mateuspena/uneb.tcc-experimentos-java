package io.github.mateuspena.app2.strategy.impl;

import io.github.mateuspena.app2.domain.Factorial;
import io.github.mateuspena.app2.strategy.IFactorialCalculator;

import java.util.ArrayList;
import java.util.List;

public class ForClassicCalculator implements IFactorialCalculator {
    @Override
    public List<String> calculateAll(List<String> numbers) {
        final List<String> factorials = new ArrayList<>();

        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            factorials.add(Factorial.calculate(numbers.get(i)).toString());
        }

        return factorials;
    }
}
