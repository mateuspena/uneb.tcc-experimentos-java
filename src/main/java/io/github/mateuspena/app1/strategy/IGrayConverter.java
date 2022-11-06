package io.github.mateuspena.app1.strategy;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface IGrayConverter {
    BufferedImage convert(BufferedImage input);

    default Color grayColor(Color color) {
        int gray = (int) ((0.2989 * color.getRed()) + (0.5870 * color.getGreen()) + (0.1140 * color.getBlue()));
        return new Color(gray, gray, gray);
    }
}
