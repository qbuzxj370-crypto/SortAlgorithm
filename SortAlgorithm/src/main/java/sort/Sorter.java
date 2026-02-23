package main.java.sort;

import main.java.sort.trace.TraceListener;

/*
 * 기능: 모든 정렬 알고리즘이 공통으로 따르는 계약 정의.
 * 
 * 요구사항
 * 	정렬 알고리즘 이름을 제공해야 한다.
 * 	입력 배열을 제자리(in-place)로 정렬해야 한다.
 * 	정렬 과정에서 Trace 이벤트를 발생시킬 수 있어야 한다(리스너가 null이거나 NoOp여도 동작).
 * 	잘못된 입력(null 배열 등)에 대해 명확한 예외 처리 정책을 가져야 한다.
 * 
 * 제약
 * 	출력(System.out)은 직접 호출하지 않는다(TraceListener에 위임).
 */

public interface Sorter {
	String name();

	void sort(int[] arr, TraceListener trace);
}
