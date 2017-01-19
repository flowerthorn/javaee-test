package com.city.oa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.business.impl.EmployeeBusinessImpl;
import com.city.oa.model.EmployeeModel;

/**
 * Servlet implementation class EmployeeAddController
 */
@WebServlet({ "/EmployeeAddController", "/employee/add.action" })
public class EmployeeAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EmployeeAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			EmployeeBusinessImpl eb=new EmployeeBusinessImpl();
			EmployeeModel em=new EmployeeModel();
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			int age=Integer.valueOf(request.getParameter("age"));
			String sex=request.getParameter("sex");
			double sal=Double.valueOf(request.getParameter("sal"));
		    em.setId(id);
		    em.setName(name);
		    em.setAge(age);
		    em.setSex(sex);
		 
		    em.setSal(sal);
			eb.add(em);
			RequestDispatcher rd=request.getRequestDispatcher("add.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("add.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
