package sort.algorithms;


import sort.Sorter;
import sort.trace.*;
import sort.util.ArrayUtils;

/*
 * 기능: 삽입 정렬 알고리즘 구현.
 * 
 * 요구사항
 * 	정렬된 부분 배열에 원소를 삽입하는 방식으로 동작해야 한다.
 * 	비교 및 이동 과정에서 Trace 이벤트를 전달할 수 있어야 한다.
 * 	단계 종료 시 상태를 전달할 수 있어야 한다.
 * 
 * 제약
 * 	알고리즘 로직과 출력 로직을 분리한다.
 */

public class InsertionSort implements Sorter {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "InsertionSort";
	}

	@Override
	public void sort(int[] arr, TraceListener trace) {
		// TODO Auto-generated method stub
		if (arr == null || arr.length < 2) {
            return;
        }

        if (trace == null) {
            trace = new NoOpTraceListener();
        }
        
		for(int i = 1; i < arr.length; i++) {
	        int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                trace.onCompare(j, i, arr);

                if (arr[j] > key) {
                	ArrayUtils.swap(arr, j, j+1);
                    trace.onSwap(j, j + 1, arr);
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
            trace.onPassEnd(i, arr);
		}
	}

}
