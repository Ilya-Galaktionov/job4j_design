package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParse() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkNotCorrectSymbol() {
        NameLoad nameLoad = new NameLoad();
        String str = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str)
                .hasMessageContaining("=");
    }

    @Test
    void checkNotKey() {
        NameLoad nameLoad = new NameLoad();
        String str = "key=";
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str)
                .hasMessageContaining("key");
    }

    @Test
    void checkNotValue() {
        NameLoad nameLoad = new NameLoad();
        String str = "=value";
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str)
                .hasMessageContaining("value");
    }
}