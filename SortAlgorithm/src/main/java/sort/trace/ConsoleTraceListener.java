package sort.trace;

import java.util.Arrays;

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

public class ConsoleTraceListener implements TraceListener {
	private final TraceLevel level;
	private final int maxLogs;
	private int logCount = 0;
	
	/**기본 로그 제한 없이 TraceLevel 기준으로 콘솔 출력 리스너를 생성*/
	public ConsoleTraceListener(TraceLevel level) {
		this(level, Integer.MAX_VALUE);
	}
	
	/**TraceLevel과 최대 로그 개수를 기준으로 콘솔 출력 리스너를 생성*/
	public ConsoleTraceListener(TraceLevel level, int maxLogs) {
		this.level = level;
		this.maxLogs = maxLogs;
	}
	
	/**재 로그 수가 최대 로그 제한보다 작고, 현재 TraceLevel이 요구 레벨 이상일 때만 로그 출력 가능*/
	private boolean canLog(TraceLevel requiredLevel) {
        return logCount < maxLogs && level.allows(requiredLevel);
    }

	/**두 원소 비교 이벤트를 콘솔에 출력*/
	@Override
	public void onCompare(int i, int j, int[] arr) {
        if (canLog(TraceLevel.COMPARE)) {
            System.out.println("[COMPARE] " + i + " vs " + j + " -> " + Arrays.toString(arr));
            logCount++;
        }
    }

	/**두 원소 교환 이벤트를 콘솔에 출력*/
	@Override
	public void onSwap(int i, int j, int[] arr) {
		// TODO Auto-generated method stub
		if (canLog(TraceLevel.SWAP)) {
            System.out.println("[SWAP] " + i + " <-> " + j + " -> " + Arrays.toString(arr));
            logCount++;
        }
	}

	/**한 패스 종료 시점의 배열 상태를 콘솔에 출력*/
	@Override
	public void onPassEnd(int pass, int[] arr) {
		// TODO Auto-generated method stub
		if (canLog(TraceLevel.PASS)) {
            System.out.println("[PASS " + pass + "] " + Arrays.toString(arr));
            logCount++;
		}
	}
}
