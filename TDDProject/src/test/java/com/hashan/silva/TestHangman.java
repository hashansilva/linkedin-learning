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

import org.junit.jupiter.api.Assertions;
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
        hangman.score = 0;
    }

    @Test
    void test_alphabetCountInAWord() {
        String word = "pizza";
        char alphabet = 'a';

        Hangman hangman = new Hangman();
        int count = hangman.countAlphabet(word, alphabet);

        Assertions.assertEquals(1, count);
    }

    @Test
    void test_lengthOfFetchedWordRandom() {
        String word = hangman.fetchWord(requestedLength);
        Assertions.assertEquals(requestedLength, word.length());
    }

    @Test
    void test_uniquenessOfFetchedWord() {
        Set<String> usedWordsSet = new HashSet<String>();
        int round = 0;
        while (round < 100) {
            Assertions.assertTrue(usedWordsSet.add(hangman.fetchWord(random.nextInt(6) + 5)));
            round++;
        }
    }

    @Test
    void test_fetchClueBeforeAnyGuess() {
        String clue = hangman.fetchClue("pizza");
        Assertions.assertEquals("-----", clue);
    }

    @Test
    void test_fetchClueAfterCorrectGuess() {
        String clue = hangman.fetchClue("pizza");
        String newClue = hangman.fetchClue("pizza", clue, 'a');

        Assertions.assertEquals("----a", newClue);
    }

    @Test
    void test_fetchClueAfterIncorrectGuess() {
        String clue = hangman.fetchClue("pizza");
        String newClue = hangman.fetchClue("pizza", clue, 'x');
        Assertions.assertEquals("-----", newClue);
    }

    @Test
    void test_whenInvalidGuessThenFetchClueThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    hangman.fetchClue("pizza", "-----", '1');
                });
    }

    @Test
    void test_whenInvalidGuessThenFetchClueThrowsExceptionWithMessage() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    hangman.fetchClue("pizza", "-----", '1');
                });
        Assertions.assertEquals("Invalid character", exception.getMessage());
    }

    @Test
    void test_remainingTrialsBeforeAnyGuess(){
        hangman.fetchWord(requestedLength);
        Assertions.assertEquals(hangman.MAX_TRIALS,hangman.remainingTrials);
    }

    @Test
    void test_remainingTrialsAfterOneGuess(){
        hangman.fetchWord(requestedLength);
        hangman.fetchClue("pizza", "-----", 'a');
        Assertions.assertEquals(hangman.MAX_TRIALS - 1,hangman.remainingTrials);
    }

    @Test
    void test_scoreBeforeAnyGuess(){
        hangman.fetchWord(requestedLength);
        Assertions.assertEquals(0, hangman.score);
    }

    @Test
    void test_scoreAfterCorrectGuess(){
        String word = "pizza";
        String clue = "-----";
        char guess = 'a';

        hangman.fetchClue(word, clue, guess);
        Assertions.assertEquals((double) Hangman.MAX_TRIALS / word.length(), hangman.score);

    }

    @Test
    void test_scoreAfterInCorrectGuess(){
        String word = "pizza";
        String clue = "-----";
        char guess = 'x';

        hangman.fetchClue(word, clue, guess);
        Assertions.assertEquals(0, hangman.score);

    }

}
