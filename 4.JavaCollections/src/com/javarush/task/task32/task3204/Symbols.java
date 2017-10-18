package com.javarush.task.task32.task3204;

import java.util.ArrayList;
import java.util.List;

public abstract class Symbols {
    private String symbols;
    private int maxNumberSymbols;

    public Symbols(String symbols) {
        this.symbols = symbols;
        this.maxNumberSymbols = symbols.length()-1;
    }

    public List<String> getSymbols(int count){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int start = (int) (Math.random()*maxNumberSymbols);
            result.add(symbols.substring(start, start+1));
        }
        return result;
    }
}
