package org.example.application4.strategy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForEachMethodConverter implements IGrayConverter {
    @Override
    public BufferedImage convert(BufferedImage input) {
        final int height = input.getHeight();
        final int width = input.getWidth();

        final List<Integer> lines = IntStream.range(0, height).boxed().collect(Collectors.toList());
        final List<Integer> columns = IntStream.range(0, width).boxed().collect(Collectors.toList());
        final BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        lines.forEach(line -> columns.forEach(column -> {
            Color color = new Color(input.getRGB(column, line));
            Color grayColor = grayColor(color);

            output.setRGB(column, line, grayColor.getRGB());
        }));

        return output;
    }
}
