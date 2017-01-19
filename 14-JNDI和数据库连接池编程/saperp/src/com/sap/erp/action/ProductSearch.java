package com.sap.erp.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.erp.business.impl.ProductImpl;
import com.sap.erp.value.ProductValue;

/**
 * Servlet implementation class ProductSearch
 */
@WebServlet({ "/ProductSearch", "/product/search.do" })
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double low=0;
		double high=0;
		String name=null;
		int stock=0;
		try{
			ProductImpl product=new ProductImpl();
			String loww=request.getParameter("low");
			String highh=request.getParameter("high");
			String namee=request.getParameter("name");
			String stockk=request.getParameter("stock");
			if(loww!=null){
				low=Double.parseDouble(loww);
			}
			if(highh!=null){
				high=Double.parseDouble(highh);
			}
			
			if(namee!=null)
			{
				name=namee;
			}
			if(stockk!=null)
			{
				stock=Integer.parseInt(stockk);
			}
			List<ProductValue> list=product.getListBySearch(name, stock, low, high);
			request.setAttribute("list",list);
			RequestDispatcher rDispatcher=request.getRequestDispatcher("search.jsp");
			rDispatcher.forward(request, response);
		}catch(Exception e){e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
