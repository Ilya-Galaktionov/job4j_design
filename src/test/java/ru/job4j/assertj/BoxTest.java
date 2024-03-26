package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotEmpty()
                .isNotBlank()
                .contains("re")
                .startsWith("Sp")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 6);
        String name = box.whatsThis();
        assertThat(name).isNotBlank()
                .isNotBlank()
                .containsIgnoringCase("Tetra")
                .doesNotContain("Cube")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void whenVertex6thenVertexMinus1() {
        Box box = new Box(6, 10);
        int vert = box.getNumberOfVertices();
        assertThat(vert).isNegative()
                .isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void checkIsExist() {
        Box box = new Box(8, 6);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkIsNotExist() {
        Box box = new Box(4, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void checkAreaOfSphere() {
        Box box = new Box(0, 2);
        double area = box.getArea();
        assertThat(area).isEqualTo(50.26d, withPrecision(0.01d))
                .isCloseTo(50.27d, withPrecision(0.01d))
                .isCloseTo(50.26d, Percentage.withPercentage(1.0d))
                .isGreaterThan(50.25d);
    }
}