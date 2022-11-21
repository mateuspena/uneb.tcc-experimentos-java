package io.github.mateuspena.app1;

import io.github.mateuspena.app1.strategy.IGrayConverter;
import io.github.mateuspena.app1.strategy.impl.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

import static io.github.mateuspena.app1.domain.ImageFile.readImage;
import static io.github.mateuspena.app1.domain.ImageFile.writeImage;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
//    IGrayConverter strategy = new ForClassicConverter();
//    IGrayConverter strategy = new ForEachConverter();
//    IGrayConverter strategy = new ForEachParallelConverter();
//    IGrayConverter strategy = new ForEnhancedConverter();
    IGrayConverter strategy = new IteratorConverter();

    BufferedImage in = readImage(args[0]);
    writeImage("converted-image.jpg", strategy.convert(in));

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
