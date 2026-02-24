package main.java.sort.util;

import java.util.Arrays;

/*
 * 기능: 배열 관련 공통 유틸리티 제공.
 * 
 * 요구사항
 * 	배열 교환, 검증 등의 공통 기능을 제공해야 한다.
 * 	정렬 여부 확인 기능을 제공할 수 있어야 한다.
 * 	알고리즘 코드 중복을 줄이는 목적을 가져야 한다.
 * 
 * 제약
 * 	상태를 가지지 않는 정적 유틸리티 형태로 구성한다.
 */

public final class ArrayUtils {
	
	// 인스턴스화 방지
	private ArrayUtils() {}
	
	public static void swap(int[] arr, int i, int j) {
		if (arr == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i]= temp;
	}

	public static boolean isSorted(int[] arr) {
		if (arr == null || arr.length < 2) {
            return true;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
	}

	public static int[] copyOf(int[] arr) {
		if (arr == null) {
            return null;
        }
        return Arrays.copyOf(arr, arr.length);
	}
}
