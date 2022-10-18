package org.example.application1;

import org.example.application1.strategy.ForEachCounter;
import org.example.application1.strategy.ICounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int QUANTITY = 200000000;
    public static final int UPPER_LIMIT = 1000;

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        List<Integer> numbers = numbers();

        ICounter strategy = new ForEachCounter();
//        ICounter strategy = new RecursiveCounter();

        int count = strategy.count(numbers, 500);
        System.out.println(strategy.getClass().getName() + ": " + count);

        long end = System.currentTimeMillis();
        long seconds = ((end - begin) / 1000);

        System.out.println("seconds: " + seconds);
        TimeUnit.SECONDS.sleep(1);
        System.exit(0);
    }

    public static List<Integer> numbers() {
        List<Integer> numbers = new ArrayList<>(QUANTITY);
        Random rand = new Random();
        for (int j = 0; j < QUANTITY; j++) {
            numbers.add(rand.nextInt(UPPER_LIMIT));
        }

        return numbers;
    }
}
