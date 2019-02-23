package com.rnaufal.vowel.finder.main;

import com.rnaufal.vowel.finder.NonRepeatableVowelStreamFinder;
import com.rnaufal.vowel.finder.stream.CharSequenceStream;

/**
 * Created by rnaufal on 02/21/2019.
 */
public class MainApplication {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("\nExecutar o sistema da seguinte forma: ./gradlew run -PappArgs={stream}. Substituir {stream} pela stream desejada.");
            System.exit(0);
        }
        char foundChar = NonRepeatableVowelStreamFinder.firstChar(new CharSequenceStream(args[0]));
        if (foundChar != NonRepeatableVowelStreamFinder.NOT_FOUND) {
            System.out.println("\nOutput: " + foundChar);
        } else {
            System.out.println("\nCaracter vogal nao localizado. Por favor, tente outra stream.");
        }
    }
}
