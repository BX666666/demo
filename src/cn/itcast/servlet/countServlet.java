package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AServlet")
public class countServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*
	 * 1.获取ServletCoontext对象
	 * 2.从ServletContext对象中获取名为count的属性
	 * 3.如果存在，给访问量加1，然后保存
	 * 4.如果不存在，说明是第一次访问，用ServletContext中保存名为count的属性，值为1
	 * */
		ServletContext app=this.getServletContext();
		Integer count=(Integer)app.getAttribute("count");
		if(count==null) {
			app.setAttribute("count", 1);
		}else {
			app.setAttribute("count", count+1);
		}
		/*
		 * 向浏览器输出
		 * 需要使用响应对象
		 * */
		PrintWriter pw=response.getWriter();
		pw.print("<h1>"+count+"<h1>");
	}

}
