package com.github.luchici.onejoke.utility;

import java.util.function.Consumer;

public class OneJokeUtility {

    public static <T> Consumer<T> rethrowCheckedException(
        RethrowCheckedExceptionConsumer<T, Exception> rethrowCheckedExceptionConsumer) {

        return i -> {
            try {
                rethrowCheckedExceptionConsumer.accept(i);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

}
