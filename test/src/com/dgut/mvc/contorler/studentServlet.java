
package com.dgut.mvc.contorler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgut.mvc.bean.Student;
import com.dgut.mvc.bean.studentSeacher;
import com.dgut.mvc.service.studentService;
/**
 * Servlet implementation class studentServlet
 */
@WebServlet("*.do")
public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	studentService service = new studentService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		String order=path.substring(1,path.length()-5);
		System.out.println(order);
		try {
			Method method=getClass().getDeclaredMethod(order, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void deleteStudent(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		String sno=request.getParameter("id");
		String id=(String)request.getParameter("id");
		service.deleteStu(id);
		listStudent(request, response);
	}
	public void inputStudent(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		request.getRequestDispatcher("inputStudents.jsp").forward(request, response);
	}
	public void addStudent(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		String name=request.getParameter("studentName");
		String no=request.getParameter("studentNo");
		String sex=request.getParameter("studentSex");
		String classNo=request.getParameter("studentClass");
		String brith=request.getParameter("studentBrithday");
		String email=request.getParameter("studentEmail");
		Student who=new Student(no, name, sex, classNo, email, brith);
		System.out.println(who);
		boolean result = service.addStu(who);
		if(result)
		{
			String message="success";
			request.setAttribute("message", message);
			request.getRequestDispatcher("addSuccess.jsp").forward(request, response);
		}
		else {
			String errorMessage="fail";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("inputStudents.jsp").forward(request, response);
		}
	}
	public void edtorStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentNo=(String)request.getParameter("id1");
		Student student=service.searchNo(studentNo);
		request.setAttribute("update_student", student);
		request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
	}
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String name=(String)request.getParameter("studentName");
		String no=(String)request.getParameter("studentNo");
		String sex=(String)request.getParameter("studentSex");
		String brith=(String)request.getParameter("studentBrithday");
		String email=(String)request.getParameter("studentEmail");
		String classNo=(String)request.getParameter("studentClass");
		Student student=new Student(no, name, sex, classNo, email, brith);
		System.out.println(student);
		service.updateStudent(student);
		System.out.println("pass");
		request.getRequestDispatcher("update_success.jsp").forward(request, response);
	}
	public void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Student> students = service.getAllStudents();
			request.setAttribute("students", students);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	}
	public void searchStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentName=request.getParameter("studentName");
		String studentNo=request.getParameter("studentNo");
		String classNo=request.getParameter("classNo");
		studentSeacher seacher=new studentSeacher(studentName, studentNo, classNo);
		System.out.println(seacher);
		List<Student> searchStudents=service.searchStudents(seacher);
		System.out.println(searchStudents);
		request.setAttribute("students", searchStudents);
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
