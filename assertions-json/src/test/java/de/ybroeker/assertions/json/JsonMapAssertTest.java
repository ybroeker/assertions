package de.ybroeker.assertions.json;

import org.junit.jupiter.api.Test;


class JsonMapAssertTest {

    @Test
    void testJsonContainingEmptyObject() {
        JsonAssert.assertThat("{\"test\":{}}").jsonPathAsMap("$.test").isEmpty();
    }

}
