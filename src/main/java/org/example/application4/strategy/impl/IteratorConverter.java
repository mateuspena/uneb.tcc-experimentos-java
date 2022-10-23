package org.example.application4.strategy.impl;

import org.example.application4.strategy.IGrayConverter;

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

        final int[] pixels = input.getRGB(0, 0, width, height, null, 0, width);
        final Iterator<Integer> pixelsIterator = IntStream.range(0, pixels.length).boxed().iterator();

        while (pixelsIterator.hasNext()) {
            int index = pixelsIterator.next();

            final Color color = new Color(pixels[index]);
            final Color grayColor = grayColor(color);

            final int line = Integer.parseInt(String.valueOf(index / width));
            final int column = Integer.parseInt(String.valueOf(index % width));

            output.setRGB(column, line, grayColor.getRGB());
        }

        return output;
    }
}
