package io.github.mateuspena.app2.domain;

import java.io.*;
import java.util.List;

public abstract class TextFile {
  public static List<String> readLines(String filepath) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filepath));
    List<String> lines = reader.lines().toList();
    reader.close();

    return lines;
  }

  public static void writeLines(String filepath, List<String> lines) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
    writer.write(String.join(System.lineSeparator(), lines));
    writer.close();
  }
}
