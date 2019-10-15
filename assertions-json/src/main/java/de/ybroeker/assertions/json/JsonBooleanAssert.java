package de.ybroeker.assertions.json;

import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.util.CheckReturnValue;


/**
 * @author ybroeker
 */
public class JsonBooleanAssert extends AbstractBooleanAssert<JsonBooleanAssert> implements JsonElementAssert {

    private JsonAssert parent;

    @CheckReturnValue
    public JsonBooleanAssert(final JsonAssert parent, final boolean actual) {
        super(actual, JsonBooleanAssert.class);
        this.parent = parent;
    }

    @CheckReturnValue
    @Override
    public JsonAssert and() {
        return parent;
    }
}
