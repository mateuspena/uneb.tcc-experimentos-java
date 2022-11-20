package io.github.mateuspena.app2.strategy.impl;

import io.github.mateuspena.app2.domain.Factorial;
import io.github.mateuspena.app2.strategy.IFactorialCalculator;

import java.util.ArrayList;
import java.util.List;

public class ForEachCalculator implements IFactorialCalculator {
  @Override
  public List<String> calculateAll(List<String> numbers) {
    final List<String> factorials = new ArrayList<>();

    numbers.forEach(number -> factorials.add(Factorial.calculate(number).toString()));

    return factorials;
  }
}
