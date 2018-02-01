package de.ybroeker.assertions.json;

import org.assertj.core.api.AbstractLongAssert;
import org.assertj.core.util.CheckReturnValue;

/**
 * @author ybroeker
 */
public class JsonLongAssert extends AbstractLongAssert<JsonLongAssert> implements JsonElementAssert {

    private final JsonAssert parent;

    @CheckReturnValue
    public JsonLongAssert(final JsonAssert parent, final Long actual) {
        super(actual, JsonLongAssert.class);
        this.parent = parent;
    }

    @CheckReturnValue
    @Override
    public JsonAssert and() {
        return parent;
    }
}
