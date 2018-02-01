package de.ybroeker.assertions.json;

import org.assertj.core.util.CheckReturnValue;

/**
 * @author ybroeker
 */
public interface JsonElementAssert {
    @CheckReturnValue
    JsonAssert and();
}
