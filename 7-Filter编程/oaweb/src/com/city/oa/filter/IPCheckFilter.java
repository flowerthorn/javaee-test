package com.city.oa.filter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class IPCheckFilter
 */
@WebFilter({ "/IPCheckFilter", "/*" })
public class IPCheckFilter implements Filter {
     String ips=null;
    /**
     * Default constructor. 
     */
    public IPCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("IP过滤器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("IP过滤器方法");
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;
       String ip=req.getRemoteAddr();
       String uri=req.getRequestURI().toString();
       req.setCharacterEncoding("GBK");
       if(uri.equals("/oaweb/error.jsp")){
    		chain.doFilter(request, response);
    	   
       }
       else{
    	    if(ips.contains(ip)){
    	   res.sendRedirect("/oaweb/error.jsp");
       }
       else{
    	   	chain.doFilter(request, response);
       }
       }

	}

	public void init(FilterConfig fConfig) throws ServletException {
	System.out.println("IP过滤器初始化");
	 ServletContext application=fConfig.getServletContext();
     String realPath=application.getRealPath("/WEB-INF/ip.txt");
     try {
		BufferedReader in=new BufferedReader(new FileReader(realPath));
	      ips=in.readLine();
     } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
