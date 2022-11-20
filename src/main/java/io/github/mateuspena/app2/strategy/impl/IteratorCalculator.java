package io.github.mateuspena.app2.strategy.impl;

import io.github.mateuspena.app2.domain.Factorial;
import io.github.mateuspena.app2.strategy.IFactorialCalculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorCalculator implements IFactorialCalculator {
  @Override
  public List<String> calculateAll(List<String> numbers) {
    final List<String> factorials = new ArrayList<>();

    Iterator<String> iter = numbers.iterator();
    while (iter.hasNext()) {
      String number = iter.next();
      factorials.add(Factorial.calculate(number).toString());
    }

    return factorials;
  }
}
