package io.github.mateuspena.app1.strategy.impl;

import io.github.mateuspena.app1.strategy.IGrayConverter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.stream.IntStream;

public class IteratorConverter implements IGrayConverter {
  @Override
  public BufferedImage convert(BufferedImage input) {
    final int height = input.getHeight();
    final int width = input.getWidth();
    final BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    final int size = height * width;
    final Iterator<Integer> iter = IntStream.range(0, size).iterator();
    while (iter.hasNext()) {
      final int index = iter.next();

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
