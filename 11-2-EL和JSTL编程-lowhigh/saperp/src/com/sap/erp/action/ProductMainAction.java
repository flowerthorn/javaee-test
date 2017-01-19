package com.sap.erp.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.erp.business.impl.ProductBusinessImpl;
import com.sap.erp.model.ProductModel;

/**
 * Servlet implementation class ProductMainAction
 */
@WebServlet({ "/ProductMainAction", "/product/main.do" })
public class ProductMainAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductMainAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double low=0,high =0;
		try {
			ProductBusinessImpl pbs=new ProductBusinessImpl();
			
			String loww=request.getParameter("low");
			String highh=request.getParameter("high");
			if(loww!=null){
				low=Double.parseDouble(loww);
			}
			if(highh!=null){
				high=Double.parseDouble(highh);
			}
			System.out.print("low="+low);
			System.out.print("high="+high);
			List<ProductModel> productlist=pbs.getListBySearch(low, high);
			System.out.print(productlist.size());
			request.setAttribute("productlist", productlist);
			
			RequestDispatcher rDispatcher=request.getRequestDispatcher("main.jsp");
			rDispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
