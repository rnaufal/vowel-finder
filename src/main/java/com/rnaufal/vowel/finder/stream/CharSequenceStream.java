package com.rnaufal.vowel.finder.stream;

/**
 * Created by rnaufal on 21/02/2019.
 */
public class CharSequenceStream implements Stream {

    private final char[] chars;

    private int currentIndex;

    public CharSequenceStream(final String source) {
        this.chars = source.toCharArray();
    }

    @Override
    public char getNext() {
        if (!hasNext()) {
            throw new IllegalStateException("There is no next value on the stream");
        }
        return chars[currentIndex++];
    }

    @Override
    public boolean hasNext() {
        return currentIndex < chars.length;
    }
}
