package io.github.mateuspena.app2;

import io.github.mateuspena.app2.strategy.IFactorialCalculator;
import io.github.mateuspena.app2.strategy.impl.*;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.github.mateuspena.app2.domain.TextFile.readLines;
import static io.github.mateuspena.app2.domain.TextFile.writeLines;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        IFactorialCalculator strategy = new ForClassicCalculator();
//        IFactorialCalculator strategy = new ForEachCalculator();
//        IFactorialCalculator strategy = new ForEachParallelCalculator();
//        IFactorialCalculator strategy = new ForEnhancedCalculator();
//        IFactorialCalculator strategy = new IteratorCalculator();

        List<String> numbers = readLines(args[0]);
        writeLines("converted-numbers.txt", strategy.calculateAll(numbers));

        System.out.println("* Time elapsed: " + timeElapsedInSeconds());
        System.out.println("* Memory usage: " + memoryUsageInMegabytes());
        TimeUnit.SECONDS.sleep(1);
        System.exit(0);
    }

    private static long timeElapsedInSeconds() {
        return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime() / (1000 * 1000 * 1000);
    }

    private static long memoryUsageInMegabytes() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / (1024 * 1024);
    }
}
