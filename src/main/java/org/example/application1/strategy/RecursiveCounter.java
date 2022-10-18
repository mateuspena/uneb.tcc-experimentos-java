package org.example.application1.strategy;

import java.util.List;

public class RecursiveCounter implements ICounter {
    @Override
    public int count(List<Integer> numbers, int greaterThan) {
        return recursive(numbers, greaterThan,0, 0);
    }

    private int recursive(List<Integer> numbers, int greaterThan, int position, int count) {
        int number = numbers.get(position);
        return (numbers.size() - 1) > position
                ? recursive(numbers, greaterThan,position + 1, number > greaterThan ? count + 1 : count)
                : count;
    }
}
