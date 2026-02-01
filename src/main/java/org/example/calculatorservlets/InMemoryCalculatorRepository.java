package org.example.calculatorservlets;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCalculatorRepository {
    private final List<String> results = new ArrayList<>();
    private static InMemoryCalculatorRepository INSTANCE;

    private InMemoryCalculatorRepository() {}

    public static InMemoryCalculatorRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryCalculatorRepository();
        }
        return INSTANCE;
    }

    public void add(String expression) {
        results.add(expression);
    }

    public List<String> findAll() {
        return results;
    }
}
