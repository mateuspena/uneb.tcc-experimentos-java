package org.example.application2.strategy;

import java.math.BigInteger;
import java.util.List;

public interface IFactorial {
    List<BigInteger> calculateAll(List<BigInteger> numbers);
    BigInteger calculate(BigInteger number);
}
