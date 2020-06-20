package com.dgut.mvc.bean;

public class studentSeacher {
	String studentName;
	String studentNo;
	String classNo;
	public String getStudentName() {
		if(studentName==null || studentName.trim().equals(""))
			return "%%";
		return "%"+studentName+"%";
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNo() {
		if(studentNo==null || studentNo.trim().equals(""))
			return "%%";
		return "%"+studentNo+"%";
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getClassNo() {
		if(classNo==null || classNo.trim().equals(""))
			return "%%";
		return "%"+classNo+"%";
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public studentSeacher(String studentName, String studentNo, String classNo) {
		super();
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.classNo = classNo;
	}
	public studentSeacher() {
		super();
		// TODO 自动生成的构造函数存根
	}
	@Override
	public String toString() {
		return "studentSeacher [studentName=" + studentName + ", studentNo=" + studentNo + ", classNo=" + classNo + "]";
	}
	
}
