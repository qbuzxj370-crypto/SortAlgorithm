package sort.algorithms;

import sort.Sorter;
import sort.trace.*;
import sort.util.ArrayUtils;

/*
 * 기능: 버블 정렬 알고리즘 구현.
 * 
 * 요구사항
 * 	인접한 두 원소를 비교하며 오름차순 정렬해야 한다.
 * 	교환 발생 시 Trace 이벤트를 전달할 수 있어야 한다.
 * 	각 패스 종료 시 Trace 이벤트를 전달할 수 있어야 한다.
 * 
 * 제약
 * 	정렬 과정 출력은 직접 수행하지 않고 TraceListener에 위임한다.
 */

public class BubbleSort implements Sorter {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "BubbleSort";
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
		
		for(int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			
			for (int j = 0; j < arr.length - 1 - i; j++) {
	            trace.onCompare(j, j + 1, arr);

	            if (arr[j] > arr[j + 1]) {
	                ArrayUtils.swap(arr, j, j + 1);
	                
	                swapped = true;
	                
	                trace.onSwap(j, j + 1, arr);
	            }
	        }
	        trace.onPassEnd(i + 1, arr);
	        
	        if (!swapped) {
	            break; // 정렬 완료 시 종료
	        }
		}
	}
}
