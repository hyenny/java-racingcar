package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set(중복허용x)의 size 확인")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set에 1,2,3이 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }
}
