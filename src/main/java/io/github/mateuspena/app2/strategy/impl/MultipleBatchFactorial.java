package io.github.mateuspena.app2.strategy.impl;

import io.github.mateuspena.app2.domain.FactorialCalculator;
import io.github.mateuspena.app2.domain.FileAccessor;
import io.github.mateuspena.app2.strategy.IBatchFactorial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MultipleBatchFactorial implements IBatchFactorial {
    @Override
    public void calculateAll(String file) throws IOException {
        FileAccessor input = new FileAccessor(file);
        FileAccessor output = new FileAccessor("output.txt");

        BufferedReader reader = input.reader();
        BufferedWriter writer = output.writer();

        String number;
        while (null != (number = reader.readLine())) {
            writer.append(FactorialCalculator.calculate(number).toString());
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
