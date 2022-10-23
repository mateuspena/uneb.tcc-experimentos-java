package org.example.application4;

import org.example.application4.strategy.IGrayConverter;
import org.example.application4.strategy.impl.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedImage in = ImageIO.read(new File(args[0]));

//        IGrayConverter strategy = new ForClassicConverter();
//        IGrayConverter strategy = new ForEachConverter();
        IGrayConverter strategy = new ForEachParallelConverter();
//        IGrayConverter strategy = new ForEnhancedConverter();
//        IGrayConverter strategy = new IteratorConverter();

        long memoryBegin = memoryUsage();
        long timeBegin = System.currentTimeMillis();
        BufferedImage out = strategy.convert(in);
        long timeEnd = System.currentTimeMillis();
        long memoryEnd = memoryUsage();

        ImageIO.write(out, "jpg", new File("converted-image.jpg"));

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
