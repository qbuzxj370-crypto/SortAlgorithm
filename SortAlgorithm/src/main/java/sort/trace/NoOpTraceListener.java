package sort.trace;

/*
 * 기능: 아무 동작도 수행하지 않는 TraceListener 기본 구현.
 * 
 * 요구사항
 * 	모든 이벤트 메서드는 빈 구현이어야 한다.
 * 	어디서든 안전하게 사용할 수 있어야 한다.
 * 
 * 제약
 * 	출력, 저장, 로깅 등의 추가 동작을 포함하지 않는다.
 */

public class NoOpTraceListener implements TraceListener {

	@Override
	public void onCompare(int i, int j, int[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSwap(int i, int j, int[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPassEnd(int pass, int[] arr) {
		// TODO Auto-generated method stub
		
	}
	
}
