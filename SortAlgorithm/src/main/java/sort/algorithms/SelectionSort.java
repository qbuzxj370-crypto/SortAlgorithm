package sort.algorithms;

import sort.Sorter;
import sort.trace.*;
import sort.util.ArrayUtils;

/*
 * 기능: 선택 정렬 알고리즘 구현.
 * 
 * 요구사항
 * 	각 단계에서 최소값을 선택하여 위치를 교환해야 한다.
 * 	비교 및 교환 이벤트를 Trace로 전달할 수 있어야 한다.
 * 	패스 종료 이벤트를 전달할 수 있어야 한다.
 * 
 * 제약
 * 	출력은 직접 수행하지 않는다.
 */

public class SelectionSort implements Sorter  {
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "SelectionSort";
	}

	@Override
	public void sort(int[] arr, TraceListener trace) {
		if (arr == null || arr.length < 2) {
	        return;
	    }

	    if (trace == null) {
	        trace = new NoOpTraceListener();
	    }
		
		for(int i = 0; i < arr.length - 1; i++) {
			
			int minIdx = i;
			
			for (int j = i+1; j < arr.length - 1 - i; j++) {

				trace.onCompare(minIdx, j, arr);

	            if (arr[minIdx] > arr[j]) {
	                minIdx = j;
	            }
	        }
			if (minIdx != i) {
                ArrayUtils.swap(arr, i, minIdx);
                trace.onSwap(i, minIdx, arr);
            }

            trace.onPassEnd(i + 1, arr);
		}
	}
}
