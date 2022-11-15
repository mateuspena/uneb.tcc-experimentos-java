package io.github.mateuspena.app1.strategy.impl;

import io.github.mateuspena.app1.strategy.IGrayConverter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ForEnhancedConverter implements IGrayConverter {
    @Override
    public BufferedImage convert(BufferedImage input) {
        final int height = input.getHeight();
        final int width = input.getWidth();
        final BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        final int[] pixels = input.getRGB(0, 0, width, height, null, 0, width);

        int index = 0;
        for (int pixel : pixels) {
            final Color color = new Color(pixel);
            final Color grayColor = grayColor(color);
            final int x = index % width;
            final int y = index / width;

            output.setRGB(x, y, grayColor.getRGB());

            index++;
        }

        return output;
    }
}