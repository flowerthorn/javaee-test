package com.city.erp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.erp.business.impl.ProductBusinessImpl;
import com.city.erp.model.ProductModel;

/**
 * Servlet implementation class ProductAddController
 */
@WebServlet({ "/ProductAddController", "/product/add.action" })
public class ProductAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ProductBusinessImpl pb=new ProductBusinessImpl();
			
			ProductModel pm=new ProductModel();
			pm.setPid(request.getParameter("pid"));
			pm.setPname(request.getParameter("name"));
			double price=Double.parseDouble(request.getParameter("price"));
			pm.setPrice(price);
			pm.setQty(Integer.parseInt(request.getParameter("qty")));
			pm.setCno(Integer.parseInt(request.getParameter("cno")));
			
			pb.add(pm);
			RequestDispatcher rd=request.getRequestDispatcher("add.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){e.printStackTrace();
		response.sendRedirect("add.jsp");}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
