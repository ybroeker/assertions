package de.ybroeker.assertions.comparator;

public interface ComparingAssertion<T> {

    ComparingAssertion<T> andThat(T value);

    ComparingAssertion<T> isGreaterThan(T value);

    ComparingAssertion<T> isLessThan(T value);

    ComparingAssertion<T> isLowerThan(T value);

    ComparingAssertion<T> isEqualTo(T value);


}
