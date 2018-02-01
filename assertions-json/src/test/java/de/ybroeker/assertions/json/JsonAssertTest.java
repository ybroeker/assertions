package de.ybroeker.assertions.json;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


/**
 * @author ybroeker
 */
class JsonAssertTest {

    @Nested
    class JsonStringAssertTest {

        @Test
        void testValidJson() {
            JsonAssert.assertThat("{\"test\":\"value\"}").jsonPathAsString("$.test").isEqualTo("value");
        }

        @Test
        void testJson_notExistingValue() {
            Assertions.assertThatThrownBy(() ->
                    JsonAssert.assertThat("{\"test\":\"value\"}").jsonPathAsString("$.test").isEqualTo("nonexistent")
            ).isInstanceOf(AssertionError.class);
        }

        @Test
        void testChaining() {
            JsonAssert.assertThat("{\"test\":\"value\", \"test2\":\"value2\"}")
                    .jsonPathAsString("$.test").isEqualTo("value")
                    .and()
                    .jsonPathAsString("$.test2").isEqualTo("value2");

        }

        @Test
        void testChaining__notExistingValue() {
            Assertions.assertThatThrownBy(() ->
                    JsonAssert.assertThat("{\"test\":\"value\", \"test2\":\"value2\"}")
                            .jsonPathAsString("$.test").isEqualTo("value")
                            .and()
                            .jsonPathAsString("$.test2").isEqualTo("nonexistent")
            ).isInstanceOf(AssertionError.class);

        }
    }

    @Nested
    class JsonLongAssertTest {
        @Test
        void testJson_validValue() {
            JsonAssert.assertThat("{\"test\":5}").jsonPathAsInteger("$.test").isEqualTo(5);
        }

        @Test
        void testJson_wrongValue() {
            Assertions.assertThatThrownBy(() ->
                    JsonAssert.assertThat("{\"test\":5}").jsonPathAsInteger("$.test").isEqualTo(6)
            ).isInstanceOf(AssertionError.class);
        }

        @Test
        void testChaining() {
            JsonAssert.assertThat("{\"test\":5, \"test2\":\"value2\"}")
                    .jsonPathAsInteger("$.test").isEqualTo(5)
                    .and()
                    .jsonPathAsString("$.test2").isEqualTo("value2");
        }

    }

    @Nested
    class JsonDoubleAssertTest {
        @Test
        void testJson_validValue() {
            JsonAssert.assertThat("{\"test\":5.0}").jsonPathAsDouble("$.test").isEqualTo(5.0);
        }

        @Test
        void testJson_wrongValue() {
            Assertions.assertThatThrownBy(() ->
                    JsonAssert.assertThat("{\"test\":5.0}").jsonPathAsDouble("$.test").isEqualTo(6.0)
            ).isInstanceOf(AssertionError.class);
        }

        @Test
        void testChaining() {
            JsonAssert.assertThat("{\"test\":5.0, \"test2\":\"value2\"}")
                    .jsonPathAsDouble("$.test").isEqualTo(5.0)
                    .and()
                    .jsonPathAsString("$.test2").isEqualTo("value2");
        }
    }

}
