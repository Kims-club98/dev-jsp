package lab.ch01;

import java.util.Map;

import lab.vo.DeptVO;
import lab.vo.HashMap;

/*
 * 데이터 셋 -테이블 : row + cols
 * DepVO.java
 * Map<String,Object>map = new HashMap<>; //collection
 * 
 * */
public class DeptVOTest {
	public static void main(String[] args) {
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDeptno(20);
		//위와 같이 setter메서드를 2 번 호출하더라도 전변 하나에는 한번에 하나의 담을 수 있음.
		System.out.println(dvo.getDeptno()); // 20
		// DeptVO에는 한 번에 하나의 레코드만 기억이 가능함.
		Map<String,Object>map = new HashMap<>();
		map.put("deptno",10);
		map.put("deptno",20);
		// Map 계열도 한 번에 하나의 레코드만 기억이 가능함.
		System.out.println(map.get("deptno")); // 20
	}
}
