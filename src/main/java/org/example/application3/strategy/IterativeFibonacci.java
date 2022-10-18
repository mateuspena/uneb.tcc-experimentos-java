package org.example.application3.strategy;

import java.util.ArrayList;
import java.util.List;

public class IterativeFibonacci implements IFibonacci {

    @Override
    public List<Integer> obtainPairs(int upperLimit) {
        int f0 = 0, f1 = 1;

        List<Integer> pairs = new ArrayList<>();
        for (int f = 1; f < upperLimit; f0 = f1, f1 = f, f = f0 + f1) {
            pairs.add(f);
        }

        return pairs;
    }
}
