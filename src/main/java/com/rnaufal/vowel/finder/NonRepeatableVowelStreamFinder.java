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

        final Set<Character> seenVowels = new HashSet<>();
        final List<Character> candidateVowels = new ArrayList<>();
        Character previousCharacter = null;
        while (input.hasNext()) {
            final Character current = input.getNext();

            if (isVowel(current)) {
                if (seenVowels.add(current)) {
                    if (previousCharacter != null && !isVowel(previousCharacter)) {
                        candidateVowels.add(current);
                    }
                } else {
                    candidateVowels.remove(current);
                }
            }
            previousCharacter = current;
        }

        return candidateVowels.isEmpty() ? NOT_FOUND : candidateVowels.get(0);
    }

    private static boolean isVowel(final Character character) {
        return VOWELS.contains(character);
    }
}
