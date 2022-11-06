package io.github.mateuspena.app2;

import io.github.mateuspena.app2.strategy.IBatchFactorial;
import io.github.mateuspena.app2.strategy.impl.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String file = args[0];

//        IBatchFactorial strategy = new MultipleBatchFactorial();
        IBatchFactorial strategy = new SingleBatchFactorial();

        long memoryBegin = memoryUsage();
        long timeBegin = System.currentTimeMillis();
        strategy.calculateAll(file);
        long timeEnd = System.currentTimeMillis();
        long memoryEnd = memoryUsage();

        System.out.println("* Time elapsed: " + ((timeEnd - timeBegin) / 1000));
        System.out.println("* Memory usage: " + ((memoryEnd - memoryBegin) / (1024 * 1024)));
        TimeUnit.SECONDS.sleep(1);
        System.exit(0);
    }

    private static long memoryUsage() {
        Runtime rt = Runtime.getRuntime();
        return rt.totalMemory() - rt.freeMemory();
    }
}
