package com.city.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.erp.business.impl.ProductBusinessImpl;
import com.city.erp.model.ProductModel;

/**
 * Servlet implementation class ProductMainController
 */
@WebServlet({ "/ProductMainController", "/product/search.do" })
public class ProductMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double low = 0,high=0;
		try {
			String loww=request.getParameter("low");
			if(loww!=null){
				low=Double.parseDouble(loww);
			}
			String highh=request.getParameter("high");
			if(highh!=null){
				high=Double.parseDouble(highh);
			}

			ProductBusinessImpl pb=new ProductBusinessImpl();
			List<ProductModel> list=pb.getListBySearch(low, high);
			System.out.print(list.size());
			request.setAttribute("emplist", list);
			RequestDispatcher rd=request.getRequestDispatcher("../product/search.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();response.sendRedirect("../error.jsp");
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
