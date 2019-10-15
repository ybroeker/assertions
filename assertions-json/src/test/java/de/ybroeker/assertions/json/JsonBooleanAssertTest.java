package de.ybroeker.assertions.json;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class JsonBooleanAssertTest {


    @Test
    void testJsonContainingFalse() {
        JsonAssert.assertThat("{\"test\":true}").jsonPathAsBoolean("$.test").isTrue();
    }

    @Test
    void testJsonContainingTrue() {
        JsonAssert.assertThat("{\"test\":false}").jsonPathAsBoolean("$.test").isFalse();
    }

    @Test
    void testChaining() {
        JsonAssert.assertThat("{\"test\":true, \"test2\":false}")
                .jsonPathAsBoolean("$.test").isTrue()
                .and()
                .jsonPathAsBoolean("$.test2").isFalse();

    }

    @Test
    void testWrongValue() {
        Assertions.assertThatThrownBy(() ->
                                              JsonAssert.assertThat("{\"test\":false}").jsonPathAsBoolean("$.test").isTrue()
        ).isInstanceOf(AssertionError.class);
    }

}
