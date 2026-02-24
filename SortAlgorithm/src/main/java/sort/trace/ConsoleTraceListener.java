package main.java.sort.trace;

/*
 * 기능: 정렬 과정 이벤트를 콘솔에 출력하는 구현체.
 * 
 * 요구사항
 * 	출력 레벨에 따라 이벤트 출력 범위를 제어할 수 있어야 한다.
 * 	배열 상태를 일관된 형식으로 출력해야 한다.
 * 	과도한 로그 발생을 제어할 수 있어야 한다.
 * 
 * 제약
 * 	정렬 알고리즘 로직에 관여하지 않는다.
 * 	이벤트 처리 외의 책임을 갖지 않는다.
 */

public class ConsoleTraceListener {
	ConsoleTraceListener(TraceLevel level) {
	}

	ConsoleTraceListener(TraceLevel level, int maxLogs) {

	}
}
