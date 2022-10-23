package org.example.application4.strategy.impl;

import org.example.application4.strategy.IGrayConverter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ForClassicConverter implements IGrayConverter {
  @Override
  public BufferedImage convert(BufferedImage input) {
    final int height = input.getHeight();
    final int width = input.getWidth();
    final BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    final int[] pixels = input.getRGB(0, 0, width, height, null, 0, width);

    for (int i = 0; i < pixels.length; i++) {
      final Color color = new Color(pixels[i]);
      final Color grayColor = grayColor(color);

      final int line = Integer.parseInt(String.valueOf(i / width));
      final int column = Integer.parseInt(String.valueOf(i % width));

      output.setRGB(column, line, grayColor.getRGB());
    }

//    for (int y = 0; y < height; y++) {
//      for (int x = 0; x < width; x++) {
//        Color color = new Color(input.getRGB(x, y));
//        Color grayColor = grayColor(color);
//
//        output.setRGB(x, y, grayColor.getRGB());
//      }
//    }

    return output;
  }
}
