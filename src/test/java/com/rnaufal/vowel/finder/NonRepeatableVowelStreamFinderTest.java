package com.rnaufal.vowel.finder;

import com.rnaufal.vowel.finder.stream.CharSequenceStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Rafael Naufal on 02/21/2019.
 */
class NonRepeatableVowelStreamFinderTest {

    @ParameterizedTest(name = "input stream: {0}, expected vowel: {1}")
    @MethodSource("inputStreamProvider")
    @DisplayName("Should find non repeatable vowel")
    void testStringListCombinations(final String inputStream,
                                    final char expectedVowel) {
        char actual = NonRepeatableVowelStreamFinder.firstChar(new CharSequenceStream(inputStream));
        assertThat(actual, is(equalTo(expectedVowel)));
    }

    private static Stream<Arguments> inputStreamProvider() {
        return Stream.of(Arguments.of("aAbBABacafe", 'e'),
                         Arguments.of("AAAAAaaaa", ' '),
                         Arguments.of("afe", 'e'),
                         Arguments.of("cafe", 'a'),
                         Arguments.of("aeiou", ' '),
                         Arguments.of(" ", ' '),
                         Arguments.of("   abacate", 'e'),
                         Arguments.of("teleferico", 'i'),
                         Arguments.of("omega", 'e'),
                         Arguments.of("ttttttt", ' '),
                         Arguments.of("telefone", 'o'),
                         Arguments.of("casa", ' '),
                         Arguments.of("acordar", 'o'),
                         Arguments.of(" ", ' '),
                         Arguments.of("telefone", 'o'),
                         Arguments.of("CAFE", ' '),
                         Arguments.of("b", ' '),
                         Arguments.of("a", ' '),
                         Arguments.of("oleo", 'e'),
                         Arguments.of("agua", 'u'),
                         Arguments.of("amago", 'o'),
                         Arguments.of("voce", 'o'));
    }
}