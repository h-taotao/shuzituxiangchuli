package com.dgut.mvc.bean;

public class Student {
    private String studentNo;
    private String studentName;
    private String sex;
    private String classNo;
    private String email;
    private String brithDay;

    @Override
    public String toString() {
        return "Student{" +
                "studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", sex='" + sex + '\'' +
                ", classNo='" + classNo + '\'' +
                ", email='" + email + '\'' +
                ", brithDay='" + brithDay + '\'' +
                '}';
    }

    public Student() {
    }
    public Student(String studentNo, String studentName, String sex, String classNo, String email, String brithDay) {
        super();
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.sex = sex;
        this.classNo = classNo;
        this.email = email;
        this.brithDay = brithDay;
    }

    public void setBrithDay(String brithDay) {
        this.brithDay = brithDay;
    }
    public String getBrithDay() {
        return brithDay;
    }
    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
