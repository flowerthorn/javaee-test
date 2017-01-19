package com.city.office.document.Controller;
//取得输入的新闻信息，调用业务接口方法，
//完成增加新闻功能，然后转发到新闻增加页面add.jsp.
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.office.document.Dao.impl.NewsDaoImpl;
import com.city.office.document.model.NewsModel;
import com.city.office.document.service.impl.NewsServiceImpl;

/**
 * Servlet implementation class NewsAddController
 */
@WebServlet({ "/NewsAddController", "/news/add.action" })
public class NewsAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String no=null;
	String subject=null;
	String content=null;
	String newsdate=null;
	String author=null;
     NewsServiceImpl newserviceImpl=new NewsServiceImpl();
    String idd=request.getParameter("no");
     String sub=request.getParameter("subject");
     String con=request.getParameter("content");
     String newsdatee=request.getParameter("date");
     String anthuor=request.getParameter("author");
     if(idd!=null){
    	 no=idd;
     }
     
     if(sub!=null){
    	subject=sub;
     }
     if(con!=null){
     	content=con;
      }
     if(newsdatee!=null){
      newsdate=newsdatee;
       }
     if(anthuor!=null){
      	author=anthuor;
       }
     
     NewsModel nm=new NewsModel();
     nm.setNewsno(no);
     nm.setSubject(subject);
     nm.setAuthor(author);
     nm.setContent(content);
     nm.setNewsdate(newsdate);
 
	RequestDispatcher rDispatcher=request.getRequestDispatcher("add.jsp");
	rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
