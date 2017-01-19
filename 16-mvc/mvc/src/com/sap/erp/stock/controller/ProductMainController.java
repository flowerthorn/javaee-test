package com.sap.erp.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.erp.stock.factory.ServiceFactory;
import com.sap.erp.stock.model.ProductModel;
import com.sap.erp.stock.service.IProductService;
import com.sap.erp.stock.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductMainController
 */
@WebServlet({ "/ProductMainController", "/product/tomain.do" })
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
			     double low=0,high=0;
				IProductService productservice=ServiceFactory.createIProductService();
			
				try{
					String loww=request.getParameter("low");
					String highh=request.getParameter("high");
					if(loww!=null){
						low=Double.parseDouble(loww);
					}
					if(highh!=null){
						high=Double.parseDouble(highh);
					}
					List<ProductModel> productlist=productservice.getListBySearch(low, high);	
					request.setAttribute("productlist", productlist);
					RequestDispatcher rDispatcher=request.getRequestDispatcher("/product/main.jsp");
					rDispatcher.forward(request, response);
		
				}catch(Exception e ){e.printStackTrace();}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
