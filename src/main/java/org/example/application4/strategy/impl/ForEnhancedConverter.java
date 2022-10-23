package org.example.application4.strategy.impl;

import org.example.application4.strategy.IGrayConverter;

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
            Color color = new Color(pixel);
            Color grayColor = grayColor(color);

            int line = Integer.parseInt(String.valueOf(index / width));
            int column = Integer.parseInt(String.valueOf(index % width));
            output.setRGB(column, line, grayColor.getRGB());

            index++;
        }

        return output;
    }
}
