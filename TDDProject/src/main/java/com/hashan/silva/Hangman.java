/*
 * Copyright (c) 2023. Hashan Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 */

package com.hashan.silva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hangman {

    public static final int MAX_TRIALS = 10;
    public Set<String> usedWordsSet = new HashSet<>();
    public List<String> wordsList = new ArrayList<>();
    public int remainingTrials;
    public int score;

    /**
     * Returns how many times the alphabet appears in the word
     *
     * @param word
     * @param alphabet
     * @return
     */
    public int countAlphabet(String word, char alphabet) {
        int result = 0;
        for (char c : word.toCharArray()) {
            if (c == alphabet) {
                result++;
            }
        }
        return result;
    }

    /**
     * Returns a word of requestedLength from the wordList
     *
     * @param requestedLength
     * @return
     */
    public String fetchWord(int requestedLength) {
        String result = null;
        remainingTrials = MAX_TRIALS;
        for (String word : wordsList) {
            if (word.length() == requestedLength && usedWordsSet.add(word)) {
                result = word;
                break;
            }
        }
        return result;
    }

    /**
     * Reads each line that has a word from WordSource.txt
     */
    public void loadWords() {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("WordSource.txt"))) {
            while ((line = bufferedReader.readLine()) != null) {
                wordsList.add(line);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Returns a string of same number of dashes as the length of the word passed in
     *
     * @param word
     * @return
     */
    public String fetchClue(String word) {
        StringBuilder clue = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            clue.append("-");
        }
        return clue.toString();
    }

    /**
     * Returns a new clue
     *
     * @param word
     * @param clue
     * @param guess
     * @return
     */
    public String fetchClue(String word, String clue, char guess) {
        remainingTrials--;
        if (guess >= 'A' && guess <= 'Z') {
            guess += 32;
        }
        if (guess < 'a' || guess > 'z') {
            throw new IllegalArgumentException("Invalid character");
        }
        StringBuilder newClue = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (guess == word.charAt(i) && guess != clue.charAt(i)) {
                newClue.append(guess);
                score += (double) MAX_TRIALS / word.length();
            } else {
                newClue.append(clue.charAt(i));
            }
        }
        return newClue.toString();
    }

}
