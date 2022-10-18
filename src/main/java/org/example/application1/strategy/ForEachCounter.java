package org.example.application1.strategy;

import java.util.List;

public class ForEachCounter implements ICounter {
    @Override
    public int count(List<Integer> numbers, int greaterThan) {
        int c = 0;
        for (Integer number : numbers)
            if (number > greaterThan)
                c++;

        return c;
    }
}
