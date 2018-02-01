package de.ybroeker.assertions;

import org.assertj.core.api.*;

import java.util.function.BiFunction;

/**
 * @author ybroeker
 * @version 1, 10.12.16
 */
public class SymmetricAssert<T> extends AbstractAssert<SymmetricAssert<T>, BiFunction<T, T, Boolean>> {


    public SymmetricAssert(final BiFunction<T, T, Boolean> actual) {
        super(actual, SymmetricAssert.class);
    }

    public BooleanMatcher isSymmetricFor(T t1, T t2) {
        boolean result = actual.apply(t1, t2).equals(actual.apply(t2, t1));

        if (!result) {
            String msg = "Expecting:\n" +
                    " <%s>\n" +
                    " to be symmetric for:\n" +
                    " <%s> \n" +
                    "  and: \n" +
                    " <%s>\n" +
                    " but isn't.";

            failWithMessage(msg, actual, t1, t2);
        }

        return new BooleanMatcher(actual.apply(t1, t2), actual);

    }

    public void isReflexiveFor(final T object) {

        boolean result = actual.apply(object, object);

        if (!result) {
            String msg = "Expecting:\n" +
                    " <%s>\n" +
                    " to be reflexive for:\n" +
                    " <%s> \n" +
                    " but isn't.";

            failWithMessage(msg, actual, object);

        }

    }

    public BooleanMatcher isTransitiveFor(final T object, final T object1, final T object2) {

        boolean first = actual.apply(object, object1);
        boolean second = actual.apply(object1, object2);
        boolean third = actual.apply(object2, object);

        boolean result = (first && second && third) || (!first && !second && !third);

        if (!result) {
            String msg = "Expecting:\n" +
                    " <%s>\n" +
                    " to be transitive for:\n" +
                    " <%s> \n" +
                    " and: \n" +
                    " <%s>\n" +
                    " and: \n" +
                    " <%s>\n" +
                    " but isn't.";

            failWithMessage(msg, actual, object, object1, object2);

        }


        return new BooleanMatcher(first, actual);
    }
}
