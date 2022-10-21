package org.example.application4;

import org.example.application4.strategy.*;
import org.example.application4.strategy.impl.ForClassicConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
    String filename = args[0];
    System.out.println("Filename: " + filename);

    BufferedImage in = ImageIO.read(new File(filename));

    IGrayConverter strategy = new ForClassicConverter();
//    IGrayConverter strategy = new ForEachConverter();
//    IGrayConverter strategy = new ForEachMethodConverter();
//    IGrayConverter strategy = new ForEachStreamMethodConverter();

    long begin = System.currentTimeMillis();
    BufferedImage out = strategy.convert(in);
    long end = System.currentTimeMillis();

    ImageIO.write(out, "jpg", new File("converted-image.jpg"));

    System.out.println("Time elapsed: " + ((end - begin) / 1000));
    TimeUnit.SECONDS.sleep(1);
    System.exit(0);
  }
}
