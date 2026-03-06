package sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import sort.algorithms.BubbleSort;
import sort.trace.NoOpTraceListener;
import sort.util.ArrayUtils;
import sort.util.DataGenerator;

/*
 * 기능: 모든 정렬 알고리즘 구현에 대해 공통 동작을 검증하는 테스트 클래스.
 * 
 * 요구사항
 * 	모든 Sorter 구현이 동일한 테스트 기준을 통과해야 한다.
 * 	무작위 배열, 정렬된 배열, 역정렬 배열, 중복 배열, 음수 포함 배열에 대해 검증해야 한다.
 * 	Arrays.sort()의 결과와 비교하여 정렬 정확성을 검증해야 한다.
 * 	빈 배열과 단일 원소 배열도 정상 처리해야 한다.
 * 
 * 제약
 * 	특정 알고리즘 구현에 종속되지 않아야 한다.
 * 	테스트 데이터 생성과 정답 비교는 공통 방식으로 처리해야 한다.
 */

public class SorterTest {
	
	/**테스트 대상이 되는 Sorter 구현체 목록을 제공*/
    static Stream<Sorter> sorterProvider() {
        return Stream.of(
            new BubbleSort()
        );
    }

    @ParameterizedTest
    @MethodSource("sorterProvider")
    /**랜덤 배열에서 정렬 알고리즘이 정상 동작하는지 검증*/
    void shouldSortRandomArray(Sorter sorter) {
        int[] actual = DataGenerator.random(10, 42, 100);
        int[] expected = ArrayUtils.copyOf(actual);

        java.util.Arrays.sort(expected);
        sorter.sort(actual, new NoOpTraceListener());

        assertArrayEquals(expected, actual);
        assertTrue(ArrayUtils.isSorted(actual));
    }

    @ParameterizedTest
    @MethodSource("sorterProvider")
    /** 이미 정렬된 배열에서 알고리즘이 문제없이 동작하는지 검증*/
    void shouldSortSortedArray(Sorter sorter) {
        int[] actual = DataGenerator.sorted(10);
        int[] expected = ArrayUtils.copyOf(actual);

        java.util.Arrays.sort(expected);
        sorter.sort(actual, new NoOpTraceListener());

        assertArrayEquals(expected, actual);
        assertTrue(ArrayUtils.isSorted(actual));
    }

    @ParameterizedTest
    @MethodSource("sorterProvider")
    /**역순 배열(최악 입력)에서도 올바르게 정렬되는지 검증*/
    void shouldSortReversedArray(Sorter sorter) {
        int[] actual = DataGenerator.reversed(10);
        int[] expected = ArrayUtils.copyOf(actual);

        java.util.Arrays.sort(expected);
        sorter.sort(actual, new NoOpTraceListener());

        assertArrayEquals(expected, actual);
        assertTrue(ArrayUtils.isSorted(actual));
    }

    @ParameterizedTest
    @MethodSource("sorterProvider")
    /**중복 값이 많은 배열에서도 정렬 정확성을 검증*/
    void shouldSortDuplicateArray(Sorter sorter) {
        int[] actual = DataGenerator.duplicates(10, 3, 42);
        int[] expected = ArrayUtils.copyOf(actual);

        java.util.Arrays.sort(expected);
        sorter.sort(actual, new NoOpTraceListener());

        assertArrayEquals(expected, actual);
        assertTrue(ArrayUtils.isSorted(actual));
    }

    @ParameterizedTest
    @MethodSource("sorterProvider")
    /**음수가 포함된 배열에서도 정상적으로 정렬되는지 검증*/
    void shouldSortNegativeIncludedArray(Sorter sorter) {
        int[] actual = DataGenerator.negativeIncluded(10, 42, 10);
        int[] expected = ArrayUtils.copyOf(actual);

        java.util.Arrays.sort(expected);
        sorter.sort(actual, new NoOpTraceListener());

        assertArrayEquals(expected, actual);
        assertTrue(ArrayUtils.isSorted(actual));
    }

    @ParameterizedTest
    @MethodSource("sorterProvider")
    /**빈 배열 입력을 예외 없이 처리하는지 검증*/
    void shouldHandleEmptyArray(Sorter sorter) {
        int[] actual = new int[0];
        int[] expected = ArrayUtils.copyOf(actual);

        java.util.Arrays.sort(expected);
        sorter.sort(actual, new NoOpTraceListener());

        assertArrayEquals(expected, actual);
        assertTrue(ArrayUtils.isSorted(actual));
    }

    @ParameterizedTest
    @MethodSource("sorterProvider")
    /**원소가 하나인 배열에서도 정상 동작하는지 검증*/
    void shouldHandleSingleElementArray(Sorter sorter) {
        int[] actual = { 1 };
        int[] expected = ArrayUtils.copyOf(actual);

        java.util.Arrays.sort(expected);
        sorter.sort(actual, new NoOpTraceListener());

        assertArrayEquals(expected, actual);
        assertTrue(ArrayUtils.isSorted(actual));
    }
}
