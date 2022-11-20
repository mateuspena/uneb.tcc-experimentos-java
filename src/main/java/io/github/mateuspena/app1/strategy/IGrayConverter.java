package io.github.mateuspena.app1.strategy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public interface IGrayConverter {
  BufferedImage convert(BufferedImage input);

  default List<Integer> imagePixels(final BufferedImage image) {
    final int w = image.getWidth();
    final int h = image.getHeight();

    return Arrays.stream(image.getRGB(0, 0, w, h, null, 0, w)).boxed().toList();
  }

  default Color grayColor(final Color color) {
    int gray =
        (int)
            ((0.2989 * color.getRed()) + (0.5870 * color.getGreen()) + (0.1140 * color.getBlue()));
    return new Color(gray, gray, gray);
  }
}
