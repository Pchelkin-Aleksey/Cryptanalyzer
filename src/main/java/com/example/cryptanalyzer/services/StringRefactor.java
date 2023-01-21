package com.example.cryptanalyzer.services;

import java.util.ArrayList;

public class StringRefactor {
    private final String string;
    public StringRefactor(String string){
        this.string = string;
    }
    public ArrayList<Character> splitMessage(){
        ArrayList<Character> chars = new ArrayList<>();
        for (char ch: string.toCharArray()) {
            chars.add(ch);
        }
        return chars;
    }
}
