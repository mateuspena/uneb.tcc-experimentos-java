package org.example.application4.strategy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ForClassicConverter implements com.example.application4.strategy.IGrayConverter {
  @Override
  public BufferedImage convert(BufferedImage input) {
    int height = input.getHeight();
    int width = input.getWidth();

    BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Color color = new Color(input.getRGB(x, y));
        Color grayColor = grayColor(color);

        output.setRGB(x, y, grayColor.getRGB());
      }
    }

    return output;
  }
}
