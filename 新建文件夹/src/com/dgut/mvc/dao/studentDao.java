package com.dgut.mvc.dao;

import com.dgut.mvc.bean.Student;
import com.dgut.mvc.bean.studentSeacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class studentDao extends DAOjdbc<Student> implements daoInterface {
    public void addStudent(Connection connection, Student student) throws SQLException
    {
        String sql="INSERT INTO 学生 (studentName,studentNo,brithDay,sex,classNo,email) VALUES(?,?,?,?,?,?)";
        Object []objects={student.getStudentName(),student.getStudentNo(),student.getBrithDay(),student.getSex(),student.getClassNo(),student.getEmail()};
        upadate(connection,sql,objects);
    }
    public void deleteStudent(Connection connection,String id)throws SQLException
    {
        String sql="DELETE FROM 学生 WHERE studentNo=?";
        upadate(connection,sql,id);
    }
    public void updataStudent(Connection connection,Student student,String id)throws SQLException
    {
        String sql="UPDATE 学生 SET studentName=?,studentNo=?,sex=?,brithDay=?,classNo=?,email=? WHERE studentNo=?";
        Object []objects={student.getStudentName(),student.getStudentNo(),student.getBrithDay(),
                student.getSex(),student.getClassNo(),student.getEmail(),id};
        upadate(connection,sql,objects);
    }
    public Student searchStudent(Connection connection,String id)throws SQLException
    {
        String sql="SELECT * FROM 学生 WHERE studentNo=?";
        return fetch(connection,sql,id);
    }
    public List<Student> allInfromations(Connection connection)throws SQLException
    {
        String sql="SELECT * FROM 学生 ORDER BY studentNo";
        return fetchList(connection,sql);
    }
	@Override
	public void sort(Connection connection) throws SQLException
	{
		String sql="UPDATE 学生 ORDER BY studentNo";
		upadate(connection, sql, null);
		
	}
	@Override
	public List<Student> searchSudentSearch(Connection connection, studentSeacher studentSeacher)
			throws SQLException {
		String sql="SELECT * FROM 学生 WHERE studentName like ? AND studentNo like ? AND classNo like ?";
		sort(connection);
		Object []objects= {studentSeacher.getStudentName(),studentSeacher.getStudentNo(),studentSeacher.getClassNo()};
		return fetchList(connection, sql,objects);
		
	}


	}


