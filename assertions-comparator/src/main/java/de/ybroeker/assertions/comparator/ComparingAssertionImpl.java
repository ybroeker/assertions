package de.ybroeker.assertions.comparator;

import java.util.Comparator;

public class ComparingAssertionImpl<T> implements ComparingAssertion<T> {

    private final Comparator<T> comp;

    private final T actual;

    private ComparatorAssertion<T> parent;

    public ComparingAssertionImpl(final ComparatorAssertion<T> parent, final Comparator<T> comp, final T actual) {
        this.parent = parent;
        this.comp = comp;
        this.actual = actual;
    }

    @Override
    public ComparingAssertion<T> andThat(T value) {
        return parent.that(value);
    }

    @Override
    public ComparingAssertion<T> isGreaterThan(final T value) {
        if (!(comp.compare(actual, value) > 0)) {
            String message = "\nCompared with:\n  <%s>\n  <%s>\n is expected to be greater than:\n  <%s>";
            parent.failWithMessage(message, comp, actual, value);
        }

        return this;
    }

    @Override
    public ComparingAssertion<T> isLowerThan(final T value) {
        String message = "\nCompared with:\n  <%s>\n  <%s>\n is expected to be lower than:\n  <%s>";
        testIsLower(value, message);

        return this;
    }

    @Override
    public ComparingAssertion<T> isLessThan(final T value) {
        String message = "\nCompared with:\n  <%s>\n  <%s>\n is expected to be less than:\n  <%s>";
        testIsLower(value, message);

        return this;
    }

    /**
     * Inserted Values are {@link #comp}, {@link #actual} and {@code value}.
     *
     * @param value          the value to compare with {@link #actual}
     * @param failureMessage the failure-message, if {@code value} isn't lower than {@link #actual}
     */
    private void testIsLower(final T value, String failureMessage) {
        if (!(comp.compare(actual, value) < 0)) {
            parent.failWithMessage(failureMessage, comp, actual, value);
        }
    }

    @Override
    public ComparingAssertion<T> isEqualTo(final T value) {
        if (!(comp.compare(actual, value) == 0)) {
            String message = "\nCompared with:\n  <%s>\n  <%s>\n is expected to be equal to:\n  <%s>";
            parent.failWithMessage(message, comp, actual, value);

        }
        return this;
    }
}
