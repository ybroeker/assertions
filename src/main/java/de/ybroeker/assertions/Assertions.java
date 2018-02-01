package de.ybroeker.assertions;

import java.util.function.BiFunction;

/**
 * @author ybroeker
 * @version 1, 09.12.16
 */
public class Assertions extends org.assertj.core.api.Assertions {

    /**
     * Creates a new <code>{@link Assertions}</code>.
     */
    protected Assertions() {
        // empty
    }

    public static <T> SymmetricAssert<T> assertThat(BiFunction<T, T, Boolean> actual) {
        return new SymmetricAssert<T>(actual);
    }

}
