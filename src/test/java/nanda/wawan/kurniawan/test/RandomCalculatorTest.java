package nanda.wawan.kurniawan.test;

import nanda.wawan.kurniawan.test.resolver.RandomParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.List;
import java.util.Random;

public class RandomCalculatorTest extends AbastrackCalculaotrTest{

    @Test
    void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test Random Calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dar {totalRepetition}"
    )
    void testRandomRepeat(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test Random Calculator")
    @RepeatedTest(
            value = 10,
            name = "{displayName}"
    )
    void testRandomRepeatInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo) {
        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());

        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test Parameter")
    @ParameterizedTest(name = "{displayName} ke {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testParameneter(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource() {
        return List.of(1,2,3,4,5,6,7,8);
    }

    @DisplayName("Test Parameter")
    @ParameterizedTest(name = "{displayName} ke {0}")
    @MethodSource({"parameterSource"})
    void testMethodSource(Integer value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }
}
