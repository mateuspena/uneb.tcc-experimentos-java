package io.github.mateuspena.app1.strategy.impl;

import io.github.mateuspena.app1.strategy.IGrayConverter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

public class IteratorConverter implements IGrayConverter {
  @Override
  public BufferedImage convert(BufferedImage input) {
    final int height = input.getHeight();
    final int width = input.getWidth();
    final BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    final List<Integer> pixels = imagePixels(input);
    final Iterator<Integer> iter = pixels.iterator();

    final int[] i = {0};
    while (iter.hasNext()) {
      final int index = i[0]++;

      final Color color = new Color(iter.next());
      final Color grayColor = grayColor(color);
      final int x = index % width;
      final int y = index / width;

      output.setRGB(x, y, grayColor.getRGB());
    }

    return output;
  }
}
