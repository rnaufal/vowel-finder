package com.rnaufal.vowel.finder.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by rnaufal on 21/02/2019.
 */
class CharSequenceStreamTest {

    @Test
    void shouldNotifyMoreCharactersToProcess() {
        final Stream stream = new CharSequenceStream("abcdef");
        assertThat(stream.hasNext(), is(equalTo(true)));
        assertThat(stream.getNext(), is(equalTo('a')));
    }

    @Test
    void shouldNotifyNoMoreCharactersToProcess() {
        final Stream stream = new CharSequenceStream("testefgh");
        while (stream.hasNext()) {
            stream.getNext();
        }
        assertThat(stream.hasNext(), is(equalTo(false)));
    }

    @Test
    void shouldProcessEachCharacterOfStream() {
        final String source = "exercise";
        final char[] values = source.toCharArray();

        final Stream stream = new CharSequenceStream(source);
        int i = 0;
        while (stream.hasNext()) {
            char actual = stream.getNext();
            assertThat(actual, is(equalTo(values[i++])));
        }
        assertThat(stream.hasNext(), is(equalTo(false)));
    }

    @Test
    void shouldThrowExceptionWhenInvalidStreamState() {
        final String sequence = "abc";
        final Stream stream = new CharSequenceStream(sequence);
        for (int i = 0; i < 5; i++) {
            if (i == sequence.length()) {
                Assertions.assertThrows(IllegalStateException.class, stream::getNext);
                break;
            }
            stream.getNext();
        }
    }

    @Test
    void shouldThrowExceptionWhenInvalidStream() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CharSequenceStream(null));
    }
}