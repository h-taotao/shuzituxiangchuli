package com.dgut.mvc.dao;
import com.dgut.mvc.bean.Student;
import com.dgut.mvc.bean.studentSeacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface daoInterface {
    public void addStudent(Connection connection, Student student) throws SQLException;
    public void deleteStudent(Connection connection, String id)throws SQLException;
    public void updataStudent(Connection connection, Student student, String id)throws SQLException;
    public Student searchStudent(Connection connection, String id)throws SQLException;
    public List<Student> allInfromations(Connection connection)throws SQLException;
    public List<Student> searchSudentSearch(Connection connection,studentSeacher studentSeacher)throws SQLException;
    public void sort(Connection connection) throws SQLException;
}

