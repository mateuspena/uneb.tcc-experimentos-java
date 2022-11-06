package io.github.mateuspena.app2.strategy.impl;

import io.github.mateuspena.app2.domain.FactorialCalculator;
import io.github.mateuspena.app2.domain.FileAccessor;
import io.github.mateuspena.app2.strategy.IBatchFactorial;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MultipleBatchFactorial implements IBatchFactorial {
    @Override
    public void calculateAll(String file) throws IOException {
        FileAccessor input = new FileAccessor(file);
        FileAccessor output = new FileAccessor("output.txt");

        Scanner reader = input.getFileReader();
        FileWriter writer = output.getFileWriter();

        String number;
        while (null != (number = input.readLine(reader))) {
            output.writeLine(writer, FactorialCalculator.calculate(number));
        }

        reader.close();
        writer.close();
    }
}
