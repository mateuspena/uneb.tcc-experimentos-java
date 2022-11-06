package io.github.mateuspena.app2.domain;

import java.io.*;

public class FileAccessor {
    private final String filepath;

    public FileAccessor(String filepath) {
        this.filepath = filepath;
    }

    public BufferedReader reader() throws IOException {
        return new BufferedReader(new FileReader(filepath));
    }

    public BufferedWriter writer() throws IOException {
        return new BufferedWriter(new FileWriter(filepath));
    }

    public String[] readLines() throws IOException {
        BufferedReader reader = reader();
        String[] lines = reader.lines().toArray(String[]::new);
        reader.close();
        return lines;
    }

    public void writeLines(String[] lines) throws IOException {
        BufferedWriter writer = writer();
        writer.write(String.join("\n", lines));
        writer.close();
    }

}
