package org.example.application4;

import org.example.application4.strategy.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedImage in = ImageIO.read(new File("C:\\Users\\Mateus\\Downloads\\foto-01.jpg"));

//    IGrayConverter strategy = new ForClassicConverter();
//    IGrayConverter strategy = new ForEachConverter();
//    IGrayConverter strategy = new ForEachMethodConverter();
    IGrayConverter strategy = new ForEachStreamMethodConverter();

    long begin = System.currentTimeMillis();
    BufferedImage out = strategy.convert(in);
    long end = System.currentTimeMillis();

    ImageIO.write(out, "jpg", new File("C:\\Users\\Mateus\\Downloads\\foto-01-saved.jpg"));

    System.out.println("Time elapsed: " + ((end - begin) / 1000));
  }
}
