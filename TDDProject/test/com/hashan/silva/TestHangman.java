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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestHangman {

    private static Random random;
    private static Hangman hangman;

    private int requestedLength;

    @BeforeAll
    public static void setupTests() {
        random = new Random();
        hangman = new Hangman();
        hangman.loadWords();
    }

    @BeforeEach
    public void setupTest() {
        requestedLength = random.nextInt(5) + 6;
    }

    @Test
    void test_alphabetCountInAWord() {
        String word = "pizza";
        char alphabet = 'a';

        Hangman hangman = new Hangman();
        int count = hangman.countAlphabet(word, alphabet);

        assertEquals(1, count);
    }

    @Test
    void test_lengthOfFetchedWordRandom() {
        String word = hangman.fetchWord(requestedLength);
        assertEquals(requestedLength, word.length());
    }

    @Test
    void test_uniquenessOfFetchedWord() {
        Set<String> usedWordsSet = new HashSet<String>();
        int round = 0;
        while (round < 100) {
            assertTrue(usedWordsSet.add(hangman.fetchWord(random.nextInt(6) + 5)));
            round++;
        }
    }

    @Test
    void test_fetchClueBeforeAnyGuess() {
        String clue = hangman.fetchClue("pizza");
        assertEquals("-----", clue);
    }

    @Test
    void test_fetchClueAfterCorrectGuess() {
        String clue = hangman.fetchClue("pizza");
        String newClue = hangman.fetchClue("pizza", clue, 'a');

        assertEquals("----a", newClue);
    }

    @Test
    void test_fetchClueAfterIncorrectGuess() {
        String clue = hangman.fetchClue("pizza");
        String newClue = hangman.fetchClue("pizza", clue, 'x');
        assertEquals("-----", newClue);
    }

    @Test
    void test_whenInvalidGuessThenFetchClueThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    hangman.fetchClue("pizza", "-----", '1');
                });
    }

    @Test
    void test_whenInvalidGuessThenFetchClueThrowsExceptionWithMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    hangman.fetchClue("pizza", "-----", '1');
                });
        assertEquals("Invalid character", exception.getMessage());
    }

}
