package de.ybroeker.assertions.json;

import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.util.CheckReturnValue;

/**
 * @author ybroeker
 */
public class JsonStringAssert extends AbstractCharSequenceAssert<JsonStringAssert, String> implements JsonElementAssert {

    private JsonAssert parent;

    @CheckReturnValue
    public JsonStringAssert(final JsonAssert parent, final String actual) {
        super(actual, JsonStringAssert.class);
        this.parent = parent;
    }

    @CheckReturnValue
    @Override
    public JsonAssert and() {
        return parent;
    }
}
