package io.github.mateuspena.app1.strategy.impl;

import io.github.mateuspena.app1.strategy.IGrayConverter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class ForEnhancedConverter implements IGrayConverter {
  @Override
  public BufferedImage convert(BufferedImage input) {
    final int height = input.getHeight();
    final int width = input.getWidth();
    final BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    final int size = height * width;
    for (int index : IntStream.range(0, size).toArray()) {
      final int x = index % width;
      final int y = index / width;
      final int pixel = input.getRGB(x, y);

      final Color color = new Color(pixel);
      final Color grayColor = grayColor(color);
      output.setRGB(x, y, grayColor.getRGB());
    }

    return output;
  }
}
