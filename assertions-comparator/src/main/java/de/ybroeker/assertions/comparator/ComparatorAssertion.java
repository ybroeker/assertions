package de.ybroeker.assertions.comparator;

import java.util.Comparator;

import org.assertj.core.api.AbstractObjectAssert;


public class ComparatorAssertion<T> extends AbstractObjectAssert<ComparatorAssertion<T>, Comparator<T>> {

    public ComparatorAssertion(final Comparator<T> actual) {
        super(actual, ComparatorAssertion.class);
    }

    public static <T> ComparatorAssertion<T> assertComparedWith(Comparator<T> comparator) {
        return new ComparatorAssertion<>(comparator);
    }

    public ComparingAssertion<T> that(final T value) {
        return new ComparingAssertionImpl<>(this, actual, value);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Overridden to wide scope.
     */
    @Override
    protected void failWithMessage(final String errorMessage, final Object... arguments) {
        super.failWithMessage(errorMessage, arguments);
    }

}
