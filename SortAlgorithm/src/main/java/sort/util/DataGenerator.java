package main.java.sort.util;

import java.util.*;

/*
 * 기능: 테스트 및 데모용 데이터 생성.
 * 
 * 요구사항
 * 	랜덤, 정렬된 배열, 역정렬 배열 등을 생성할 수 있어야 한다.
 * 	중복 데이터 패턴을 생성할 수 있어야 한다.
 * 	재현 가능한 생성을 위해 시드 기반 생성이 가능해야 한다.
 * 
 * 제약
 * 	정렬 로직을 포함하지 않는다.
 */

public class DataGenerator {
	
	private DataGenerator() {}
	
	/**랜덤 배열*/
	public static int[] random(int n, int seed, int bound) {

		validateSize(n);
		validateBound(bound);

        Random random = new Random(seed);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
		
		return arr;
	}
	
	/**오릉차순 배열*/
	public static int[] sorted(int n) {

		validateSize(n);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        
        return arr;
		
	}
	
	/**내림치순 배열*/
	public static int[] reversed(int n) {

		validateSize(n);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - 1 - i;
        }
        
        return arr;
	}
	
	/**중복이 믾은 배열*/
	public static int[] duplicates(int n, int distinctCount, int seed) {


		validateSize(n);

	    if (distinctCount <= 0 || distinctCount > n) {
	        throw new IllegalArgumentException("distinctCount must be between 1 and n");
	    }

	    Random random = new Random(seed);
	    int[] arr = new int[n];

	    for (int i = 0; i < n; i++) {
	        arr[i] = random.nextInt(distinctCount);
	    }

	    return arr;
	}
	/**음수 포함 배열*/
	public static int[] negativeIncluded(int n, int seed, int bound) {

		validateSize(n);
		validateBound(bound);

	    Random random = new Random(seed);
	    int[] arr = new int[n];

	    for (int i = 0; i < n; i++) {
	        arr[i] = random.nextInt(bound * 2) - bound;
	    }

	    return arr;
	}
	
	private static void validateSize(int n) {
	    if (n < 0) {
	        throw new IllegalArgumentException("Size must be >= 0");
	    }
	}

	private static void validateBound(int bound) {
	    if (bound <= 0) {
	        throw new IllegalArgumentException("Bound must be > 0");
	    }
	}
}
