package de.ybroeker.assertions;

import org.assertj.core.api.AbstractBooleanAssert;

import java.util.function.BiFunction;

/**
 * @author ybroeker
 * @version 1, 11.12.16
 */
public class BooleanMatcher extends AbstractBooleanAssert<BooleanMatcher> {

    BiFunction biFunction;

    public BooleanMatcher(final Boolean actual, BiFunction biFunction) {
        super(actual, BooleanMatcher.class);
        this.biFunction = biFunction;
    }

    public void andTrue() {

        if (!actual) {
            String msg = "Expecting:\n" +
                    " <%s>\n" +
                    " to be true";

            failWithMessage(msg, biFunction);
        }

    }

    public void andFalse() {

        if (actual) {
            String msg = "Expecting:\n" +
                    " <%s>\n" +
                    " to be false";

            failWithMessage(msg, biFunction);
        }

    }
}
