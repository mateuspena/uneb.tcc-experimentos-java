package org.example.application3;

import org.example.application3.strategy.IterativeFibonacci;

public class Main {
    public static void main(String[] args) {
        IterativeFibonacci iterativeFibonacci = new IterativeFibonacci();
        System.out.println(iterativeFibonacci.obtainPairs(10));
    }
}
