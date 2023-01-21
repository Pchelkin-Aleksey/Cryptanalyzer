package com.example.cryptanalyzer.services;

import com.example.cryptanalyzer.constant.Alphabet;
import java.util.ArrayList;

public class Decoder  {
    private char getShiftSymbol(String alphabet, int position, int key){
        int shiftIndex = position - Math.abs(key) % alphabet.length();
        if (shiftIndex < 0)
            shiftIndex =  shiftIndex + alphabet.length();
        return alphabet.charAt(shiftIndex);
        }

    public String decode(String text, int key){
        StringRefactor stringRefactor = new StringRefactor(text);
        ArrayList<Character> chars = stringRefactor.splitMessage();
        StringBuilder stringBuilder = new StringBuilder();
        char symbol;
        int posSymbol;
        for (char ch : chars) {
            if (Character.isLetter(ch) && Character.isUpperCase(ch)) {
                posSymbol = Alphabet.SYMBOLS_CAPITAL.indexOf(ch);
                symbol = getShiftSymbol(Alphabet.SYMBOLS_CAPITAL, posSymbol, key);
            } else if (Character.isLetter(ch) && Character.isLowerCase(ch)) {
                posSymbol = Alphabet.SYMBOLS_SMALL.indexOf(ch);
                symbol = getShiftSymbol(Alphabet.SYMBOLS_SMALL, posSymbol, key);
            }
            else
                symbol = ch;
            stringBuilder.append(symbol);
        }
        return stringBuilder.toString();
    }

    public String[] bruteForce(String text){
        String[] results = new String[Alphabet.SYMBOLS_SMALL.length()];
        for (int i = 0; i < Alphabet.SYMBOLS_SMALL.length(); i++)
            results[i] = decode(text, i);
        return results;
    }
}