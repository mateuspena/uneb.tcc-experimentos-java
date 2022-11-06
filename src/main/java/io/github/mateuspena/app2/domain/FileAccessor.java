package io.github.mateuspena.app2.domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAccessor {
    private final File file;

    public FileAccessor(String filepath) {
        file = new File(filepath);
    }

    public Scanner getFileReader() throws IOException {
        return new Scanner(file);
    }

    public FileWriter getFileWriter() throws IOException {
        return new FileWriter(file);
    }

    public String readLine(Scanner fileReader) {
        return fileReader.hasNext() ? fileReader.nextLine() : null;
    }

    public List<String> readLines() throws IOException {
        List<String> lines = new ArrayList<>();

        Scanner reader = getFileReader();
        String line;
        while (null != (line = readLine(reader))) {
            lines.add(line);
        }

        reader.close();
        return lines;
    }

    public void writeLine(FileWriter fileWriter, Object line) throws IOException {
        fileWriter.write(String.valueOf(line).concat("\n"));
    }

    public void writeLines(List<?> lines) throws IOException {
        FileWriter writer = getFileWriter();

        for (Object line : lines) {
            writeLine(writer, line);
        }

        writer.close();
    }


}
