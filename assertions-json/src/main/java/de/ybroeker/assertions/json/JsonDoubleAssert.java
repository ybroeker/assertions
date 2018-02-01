package de.ybroeker.assertions.json;

import org.assertj.core.api.AbstractDoubleAssert;
import org.assertj.core.util.CheckReturnValue;

/**
 * @author ybroeker
 */
public class JsonDoubleAssert extends AbstractDoubleAssert<JsonDoubleAssert> implements JsonElementAssert {

    private final JsonAssert parent;

    @CheckReturnValue
    public JsonDoubleAssert(final JsonAssert parent, final Double actual) {
        super(actual, JsonDoubleAssert.class);
        this.parent = parent;
    }

    @CheckReturnValue
    @Override
    public JsonAssert and() {
        return parent;
    }
}
