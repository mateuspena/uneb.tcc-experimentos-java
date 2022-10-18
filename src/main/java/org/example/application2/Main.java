package org.example.application2;

import org.example.application2.strategy.ForEachFactorial;
import org.example.application2.strategy.IFactorial;
import org.example.application2.strategy.ForClassicFactorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int QUANTITY = 300000;
    public static final int UPPER_LIMIT = 15;

    public static void main(String[] args) throws InterruptedException {
        List<BigInteger> numbers = numbers();

        IFactorial strategy = new ForEachFactorial();
//        IFactorial strategy = new ForClassicFactorial();
//        IFactorial strategy = new RecursiveFactorial();

        List<BigInteger> factorials = strategy.calculateAll(numbers);

//        System.out.println(numbers);
//        System.out.println(factorials);

        TimeUnit.SECONDS.sleep(1);
        System.exit(0);
    }

    public static List<BigInteger> numbers() {
        List<BigInteger> numbers = new ArrayList<>(QUANTITY);
        Random rand = new Random();
        for (int j = 0; j < QUANTITY; j++) {
            numbers.add(BigInteger.valueOf(rand.nextInt(UPPER_LIMIT)));
        }

        return numbers;
    }

}
