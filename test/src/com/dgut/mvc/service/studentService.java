package com.dgut.mvc.service;

import com.dgut.mvc.bean.Student;
import com.dgut.mvc.bean.studentSeacher;
import com.dgut.mvc.dao.studentDao;
import com.dgut.mvc.jdbcutils.jdbctools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.BlockingDeque;

public class studentService {
	studentDao dao=new studentDao();
    public List<Student> getAllStudents() throws SQLException {
        Connection connection=null;
        try {
            connection=jdbctools.connectCp30();
            //dao.sort(connection);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return dao.allInfromations(connection);
    }

    public void deleteStu(String id) throws SQLException {
    	Connection connection=null;
    	try {
			connection=jdbctools.connectCp30();
			dao.deleteStudent(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally {
			jdbctools.close_CSR(connection, null);
		}	
	}
    public Student searchNo(String No) throws Exception {
    	Connection connection=null;
    	connection=jdbctools.connectCp30();
    	Student student=dao.searchStudent(connection,No);
		return student;
	}
    public boolean addStu(Student student) throws SQLException {
        Connection connection=null;
        boolean flag=false;
        try {
            connection=jdbctools.connectCp30();
        	dao.addStudent(connection, student);
        	System.out.println(dao.allInfromations(connection));
        	flag=true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
			jdbctools.close_CSR(connection, null);
		}
		return flag;
	}
    public void updateStudent(Student student) throws Exception 
    {
    	Connection connection=null;
    	connection=jdbctools.connectCp30();
    	dao.updataStudent(connection, student, student.getStudentNo());
    	jdbctools.close_CSR(connection, null);
	}
    public List<Student> searchStudents(studentSeacher seacher) throws Exception {
    	Connection connection=null;
    	connection=jdbctools.connectCp30();
    	List<Student> students=dao.searchSudentSearch(connection, seacher);
    	System.out.println(students);
    	jdbctools.close_CSR(connection, null);
    	return students;
	}
    
}
