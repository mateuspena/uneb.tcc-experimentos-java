package io.github.mateuspena.app1;

import io.github.mateuspena.app1.strategy.IGrayConverter;
import io.github.mateuspena.app1.strategy.impl.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        IGrayConverter strategy = new ForClassicConverter();
//        IGrayConverter strategy = new ForEachConverter();
//        IGrayConverter strategy = new ForEachParallelConverter();
//        IGrayConverter strategy = new ForEnhancedConverter();
        IGrayConverter strategy = new IteratorConverter();

        BufferedImage in = ImageIO.read(new File(args[0]));
        BufferedImage out = strategy.convert(in);
        ImageIO.write(out, "jpg", new File("converted-image.jpg"));

        System.out.println("* Time elapsed: " + timeUsageInSeconds());
        System.out.println("* Memory usage: " + memoryUsageInMegabytes());
        TimeUnit.SECONDS.sleep(1);
        System.exit(0);
    }

    private static long timeUsageInSeconds() {
        return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime() / (1000 * 1000 * 1000);
    }

    private static long memoryUsageInMegabytes() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / (1024 * 1024);
    }
}
