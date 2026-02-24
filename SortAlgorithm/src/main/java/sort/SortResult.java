package main.java.sort;

/*
 * 기능: 정렬 실행 결과를 요약해서 반환(통계/검증/추적 개수 등).
 * 
 * 요구사항
 * 	정렬 전/후 기본 정보(배열 길이, 수행 시간 등)를 담을 수 있어야 한다.
 * 	비교 횟수, 교환 횟수 등 “계측값”을 담을 수 있어야 한다(선택).
 * 	필요 시 “정렬 성공 여부(isSorted)” 같은 검증 결과를 포함할 수 있어야 한다.
 * 
 * 제약
 * 	Sorter 인터페이스를 단순화하려면 이 클래스는 나중에 도입해도 된다.
 */
public class SortResult {
	long elapsedNanos;
	long comparisons;
	long swaps;
	boolean sorted;
}
