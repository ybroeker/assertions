package de.ybroeker.assertions;

import java.util.function.BiFunction;

import org.junit.jupiter.api.Test;

/**
 * @author ybroeker
 * @version 1, 10.12.16
 */
public class SymmetricAssertTest {


    @Test
    public void isSymmetricFor() throws Exception {
        //Arrange

        Object object = new Object();
        Object object2 = new Object();


        //Act


        //Assert
        Assertions.assertThat((BiFunction<Object, Object, Boolean>) Object::equals).isSymmetricFor(object, object2);
    }

    @Test
    public void testNotSymmetric() throws Exception {
        //Arrange
        Object object = new Object() {
            public boolean equals(Object o) {
                return true;
            }
        };
        Object object2 = new Object();


        //Act
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> Assertions.assertThat((BiFunction<Object, Object, Boolean>) Object::equals).isSymmetricFor(object, object2))

                //Assert
                .isInstanceOf(AssertionError.class)
                .hasMessageContaining("Expecting:")
                .hasMessageContaining("to be symmetric for:")
                .hasMessageContaining("and:")
                .hasMessageContaining("but isn't");

    }

    @Test
    public void testReflexive() {
        Object object = new Object();

        Assertions.assertThat((BiFunction<Object, Object, Boolean>) Object::equals).isReflexiveFor(object);
    }

    @Test
    public void testTransitiveAllUnequal() {
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();


        Assertions.assertThat((BiFunction<Object, Object, Boolean>) Object::equals).isTransitiveFor(object, object1, object2).andFalse();
    }

    @Test
    public void testTransitiveAllEqual() {
        Object object = new Object() {
            public boolean equals(Object o) {
                return true;
            }
        };
        Object object1 = new Object() {
            public boolean equals(Object o) {
                return true;
            }
        };
        Object object2 = new Object() {
            public boolean equals(Object o) {
                return true;
            }
        };


        Assertions.assertThat((BiFunction<Object, Object, Boolean>) Object::equals).isTransitiveFor(object, object1, object2).andTrue();
    }

    @Test
    public void testTransitiveSomeUnEqual() {
        Object object = new Object() {
            public boolean equals(Object o) {
                return true;
            }
        };
        Object object1 = new Object() {
            public boolean equals(Object o) {
                return true;
            }
        };
        Object object2 = new Object() {
            public boolean equals(Object o) {
                return false;
            }
        };


        //Act
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> Assertions.assertThat((BiFunction<Object, Object, Boolean>) Object::equals).isTransitiveFor(object, object1, object2))

                //Assert
                .isInstanceOf(AssertionError.class)
                .hasMessageContaining("Expecting:")
                .hasMessageContaining("to be transitive for:")
                .hasMessageContaining("and:")
                .hasMessageContaining("but isn't");
    }

}
