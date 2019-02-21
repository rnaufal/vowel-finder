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

    private NonRepeatableVowelStreamFinder() {

    }

    public static char firstChar(Stream input) {
        if (input == null) {
            return ' ';
        }

        final Set<Character> repeatedVowels = new HashSet<>();
        final List<Character> candidateVowels = new ArrayList<>();

        Character lastCharacter = ' ';
        while (input.hasNext()) {
            final Character current = input.getNext();

            if (!repeatedVowels.contains(current)) {
                if (candidateVowels.contains(current)) {
                    repeatedVowels.add(current);
                    candidateVowels.remove(current);
                } else if (VOWELS.contains(current) && !VOWELS.contains(lastCharacter)) {
                    candidateVowels.add(current);
                } else if (VOWELS.contains(lastCharacter)) {
                    candidateVowels.remove(lastCharacter);
                }
            }

            lastCharacter = current;
        }

        return candidateVowels.isEmpty() ? ' ' : candidateVowels.get(candidateVowels.size() - 1);
    }
}
