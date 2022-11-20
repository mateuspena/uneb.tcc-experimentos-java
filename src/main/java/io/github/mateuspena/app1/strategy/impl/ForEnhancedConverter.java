package io.github.mateuspena.app1.strategy.impl;

import io.github.mateuspena.app1.strategy.IGrayConverter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class ForEnhancedConverter implements IGrayConverter {
  @Override
  public BufferedImage convert(BufferedImage input) {
    final int height = input.getHeight();
    final int width = input.getWidth();
    final BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    final List<Integer> pixels = imagePixels(input);

    final int[] i = {0};
    for (int pixel : pixels) {
      final int index = i[0]++;

      final Color color = new Color(pixel);
      final Color grayColor = grayColor(color);
      final int x = index % width;
      final int y = index / width;

      output.setRGB(x, y, grayColor.getRGB());
    }

    return output;
  }
}
