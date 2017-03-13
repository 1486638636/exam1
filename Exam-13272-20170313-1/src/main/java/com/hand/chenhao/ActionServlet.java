package com.hand.chenhao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.hand.Customer.CustomerDAO;
import com.hand.entity.Customer;
import com.hand.entity.Film;
import com.hand.entity.Language;




public class ActionServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uri=request.getRequestURI();
		
		String action = uri.substring(uri.lastIndexOf("/")+1 , uri.lastIndexOf("."));
		System.out.println(action);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if ("login".equals(action)) {		
			CustomerDAO dao = new CustomerDAO();
			String userName = request.getParameter("name");			
		
			if(dao.findUser(userName)){
				response.sendRedirect("list.do");
//				request.getRequestDispatcher("list.jsp").forward(request, response);
			}else {		
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		if("list".equals(action)){		
			try {
			
				CustomerDAO dao = new CustomerDAO();
				List<Film> fList= dao.findAll();
				List<Language> lList=dao.findLName();
				request.setAttribute("fList", fList);
				request.setAttribute("lList",lList);
			    request.getRequestDispatcher("list.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
		      }
	      }
      }
}

