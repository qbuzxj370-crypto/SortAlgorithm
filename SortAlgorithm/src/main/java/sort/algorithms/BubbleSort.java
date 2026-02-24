package main.java.sort.algorithms;

import main.java.sort.Sorter;
import main.java.sort.trace.*;

/*
 * 기능: 정렬 과정 이벤트를 메모리에 기록하는 구현체.
 * 
 * 요구사항
 * 	발생한 이벤트를 내부 리스트 등에 저장할 수 있어야 한다.
 * 	저장된 이벤트를 외부에서 조회할 수 있어야 한다.
 * 	스냅샷 포함 여부를 선택적으로 제어할 수 있어야 한다.
 * 
 * 제약
 * 	출력 책임을 갖지 않는다.
 * 	정렬 알고리즘 동작에 영향을 주지 않는다.
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
			for(int j = 1; j < arr.length - 1 - i; j++) {
				trace.onCompare(j, j + 1, arr);

	            if (arr[j] > arr[j + 1]) {

	                int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;

	                trace.onSwap(j, j + 1, arr);
	            }
	        }

	        trace.onPassEnd(i + 1, arr);
		}
	}
}
