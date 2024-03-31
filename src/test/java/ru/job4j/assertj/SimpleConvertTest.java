package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }
    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> rsl = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(rsl).isNotEmpty()
                .hasSize(5)
                .startsWith("first")
                .contains("three", Index.atIndex(2))
                .doesNotContain("six");
    }
    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> rsl = simpleConvert.toSet("a", "b", "c", "d", "c");
        assertThat(rsl).isNotEmpty()
                .hasSize(4)
                .doesNotContain("n")
                .allSatisfy(e -> assertThat(e).containsAnyOf("a", "b", "c", "d"))
                .anySatisfy(e -> assertThat(e).isEqualTo("a"))
                .allMatch(e -> e.length() == 1);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> rsl = simpleConvert.toMap("a", "b", "c", "d", "1");
        assertThat(rsl).hasSize(5)
                .containsKeys("a", "1")
                .containsValues(1, 3, 4)
                .doesNotContainKey("5")
                .doesNotContainValue(5)
                .containsEntry("a", 0);
    }
}