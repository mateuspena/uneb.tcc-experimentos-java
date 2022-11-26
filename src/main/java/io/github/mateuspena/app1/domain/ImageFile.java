package io.github.mateuspena.app1.domain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class ImageFile {
  public static BufferedImage readImage(String filepath) throws IOException {
    return ImageIO.read(new File(filepath));
  }

  public static void writeImage(String filepath, BufferedImage image) throws IOException {
    ImageIO.write(image, "jpg", new File(filepath));
  }
}
