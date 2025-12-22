package lab.vo;

import java.util.Map;

public class DeptVO {
	// 접근 제한자를 private으로 하면 위부에서 접근 불가
	private int deptno; // 부서번호(읽기와 쓰기)
	private String dname; // 부서명(읽기와 쓰기)
	private String loc; // 지역(읽기와 쓰기)
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;

	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
