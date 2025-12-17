package lab.ch01;


public class NPEtest{
	// 파라미터 자리를 통해 초기화기 호출될 때 일어난다.(이때 Null일 수도 있다 고려함.
	void methodA(String temp) {
		System.out.println("methodA 호출 성공!!!");
		// 만일 파라미터 temp에 null인 상태라도 사용하지 않는다면 예외는 발생하지 않음.
		// ▼ 예외 검증
		try {
			// 예외가 발생할 가능성이 있는 코드를 여기에 입력!
			System.out.println(temp.length());
			// 예외가 발생하였을 때 "프로그램이 멈추지 않게 하기 위해" 따로 예외처리를 함 -> 중지되지 않고 다음으로 진행이 됨.
		}catch(NullPointerException e) {
			System.out.println("Exception "+e.toString());
		}finally{
			//여기는 무조건 실행 기회를 가진다(finally)
			System.out.println("여기는 무조건 실행 기회를 지님!");
		}; // end of try-catch
		System.out.println("Here!");
		//System.out.println(temp.length());
	}; // end of methodA
	
	public static void main(String[] args) {
		 String msg = "HELLO";
		 System.out.println(msg.length());// 결과: 5		㉠
		 /* - length() 동사형은 문자열의 길이를 반환하며
		 	- length 명사형은 배열의 크기를 반환한다.
		 */
		 System.out.println("Hello".length());// 결과: 5		㉡
		 //String name = null;// 초기화하는데 null을 활용
		 //System.out.println(name.length());
		 // insert here
		 NPEtest epe = new NPEtest();
		 epe.methodA(null);	//		㉢
	}
}

