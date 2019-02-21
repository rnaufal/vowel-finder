package com.rnaufal.vowel.finder;

import com.rnaufal.vowel.finder.stream.Stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rnaufal on 21/02/2019.
 */
public class NonRepeatableVowelStreamFinder {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public static final char NOT_FOUND = ' ';

    private NonRepeatableVowelStreamFinder() {

    }

    public static char firstChar(Stream input) {
        if (input == null) {
            return ' ';
        }

        final Set<Character> repeatedVowels = new HashSet<>();
        final List<Character> candidateVowels = new ArrayList<>();
        int streamSize = 0;

        while (input.hasNext()) {
            final Character current = input.getNext();

            if (!repeatedVowels.contains(current)) {
                if (candidateVowels.contains(current)) {
                    repeatedVowels.add(current);
                    candidateVowels.remove(current);
                } else if (VOWELS.contains(current)) {
                    candidateVowels.add(current);
                }
            }

            streamSize++;
        }

        return hasFoundVowel(candidateVowels, streamSize) ? getVowel(candidateVowels) : NOT_FOUND;
    }

    private static Character getVowel(final List<Character> candidateVowels) {
        return candidateVowels.get(candidateVowels.size() - 1);
    }

    private static boolean hasFoundVowel(final List<Character> candidateVowels,
                                         final int streamSize) {
        return !candidateVowels.isEmpty() && candidateVowels.size() != streamSize;
    }
}
