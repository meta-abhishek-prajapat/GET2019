package com.metacube.eadsession3;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = "select * from studentdetail";
		List<Student> student_list = new ArrayList<Student>();
		Database db = Database.getInstances();
		ResultSet rs;
		try {
			rs = db.getData(query);
			while(rs.next()){
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setFirst_name(rs.getString(2));
				student.setLast_name( rs.getString(3));
				student.setFname(rs.getString(4));
				student.setEmail(rs.getString(5));
				student.setClass_name(rs.getInt(6));
				student.setAge(rs.getInt(7));
				student_list.add(student);
			}
			
			request.setAttribute("student_list", student_list);
			request.getRequestDispatcher("showstudents.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
