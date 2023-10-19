package com.github.luchici.onejoke.utility;

@FunctionalInterface
public interface RethrowCheckedExceptionConsumer<T, E extends Exception> {

    void accept(T t) throws E;
}
