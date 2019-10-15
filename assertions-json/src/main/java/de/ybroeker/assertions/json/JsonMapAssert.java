package de.ybroeker.assertions.json;

import java.util.*;

import org.assertj.core.api.AbstractMapAssert;
import org.assertj.core.util.CheckReturnValue;


/**
 * @author ybroeker
 */
public class JsonMapAssert<KEY, VALUE> extends AbstractMapAssert<JsonMapAssert<KEY, VALUE>, Map<KEY, VALUE>, KEY, VALUE> implements JsonElementAssert {

    private JsonAssert parent;

    @CheckReturnValue
    public JsonMapAssert(final JsonAssert parent, final Map<KEY,VALUE> actual) {
        super(actual, JsonMapAssert.class);
        this.parent = parent;
    }

    @CheckReturnValue
    @Override
    public JsonAssert and() {
        return parent;
    }

}
