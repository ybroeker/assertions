package de.ybroeker.assertions.json;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.util.CheckReturnValue;

/**
 * @author ybroeker
 */
public class JsonAssert extends AbstractCharSequenceAssert<JsonAssert, String> {

    private final DocumentContext documentContext;

    @CheckReturnValue
    public JsonAssert(final String contentAsString) {
        super(contentAsString, JsonAssert.class);
        documentContext = JsonPath.parse(actual);
    }

    @CheckReturnValue
    public static JsonAssert assertThat(String json) {
        return new JsonAssert(json);
    }


    @CheckReturnValue
    public JsonStringAssert jsonPathAsString(String path) {
        return new JsonStringAssert(this, documentContext.read(path, String.class));
    }

    @CheckReturnValue
    public JsonLongAssert jsonPathAsInteger(String path) {
        return new JsonLongAssert(this, documentContext.read(path, Long.class));
    }

    @CheckReturnValue
    public JsonDoubleAssert jsonPathAsDouble(String path) {
        return new JsonDoubleAssert(this, documentContext.read(path, Double.class));
    }


}
