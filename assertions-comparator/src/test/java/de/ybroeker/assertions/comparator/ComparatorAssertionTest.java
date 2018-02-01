package de.ybroeker.assertions.comparator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.ybroeker.assertions.comparator.ComparatorAssertion.assertComparedWith;

/**
 * @author ybroeker
 */
class ComparatorAssertionTest {

    @Test
    void testAndThat() {
        assertComparedWith(Integer::compare)
                .that(2).isGreaterThan(1)
                .andThat(3).isGreaterThan(2);
    }


    @Test
    void assertGreaterButIsLower() {
        Assertions.assertThatThrownBy(() ->
                assertComparedWith(Integer::compare).that(1).isGreaterThan(2)
        )
                .isInstanceOf(java.lang.AssertionError.class)
                .hasMessageContaining("expected to be greater");
    }


    @Test
    void assertEqualButIsLower() {
        Assertions.assertThatThrownBy(() ->
                assertComparedWith(Integer::compare).that(1).isEqualTo(2)
        )
                .isInstanceOf(java.lang.AssertionError.class)
                .hasMessageContaining("expected to be equal");
    }

    @Test
    void assertLowerAndIsLower() {
        assertComparedWith(Integer::compare).that(1).isLowerThan(2);
        assertComparedWith(Integer::compare).that(1).isLessThan(2);

    }


    @Test
    void assertGreaterButIsEqual() {
        Assertions.assertThatThrownBy(() ->
                assertComparedWith(Integer::compare).that(1).isGreaterThan(1)
        )
                .isInstanceOf(java.lang.AssertionError.class)
                .hasMessageContaining("expected to be greater");
    }

    @Test
    void assertEqualAndIsEqual() {
        assertComparedWith(Integer::compare).that(1).isEqualTo(1);
    }

    @Test
    void assertLowerButIsEqual() {
        Assertions.assertThatThrownBy(() ->
                assertComparedWith(Integer::compare).that(1).isLowerThan(1)
        )
                .isInstanceOf(java.lang.AssertionError.class)
                .hasMessageContaining("expected to be lower");

        Assertions.assertThatThrownBy(() ->
                assertComparedWith(Integer::compare).that(1).isLessThan(1)
        )
                .isInstanceOf(java.lang.AssertionError.class)
                .hasMessageContaining("expected to be less");
    }


    @Test
    void assertGreaterAndIsGreater() {
        assertComparedWith(Integer::compare).that(1).isGreaterThan(0);
    }

    @Test
    void assertEqualButIsGreater() {
        Assertions.assertThatThrownBy(() ->
                assertComparedWith(Integer::compare).that(1).isEqualTo(0)
        )
                .isInstanceOf(java.lang.AssertionError.class)
                .hasMessageContaining("expected to be equal");
    }

    @Test
    void assertLowerButIsGreater() {
        Assertions.assertThatThrownBy(() ->
                assertComparedWith(Integer::compare).that(1).isLowerThan(0)
        )
                .isInstanceOf(java.lang.AssertionError.class)
                .hasMessageContaining("expected to be lower");

        Assertions.assertThatThrownBy(() ->
                assertComparedWith(Integer::compare).that(1).isLessThan(0)
        )
                .isInstanceOf(java.lang.AssertionError.class)
                .hasMessageContaining("expected to be less");
    }

}
