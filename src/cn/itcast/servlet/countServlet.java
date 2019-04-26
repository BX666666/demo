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
	 * 1.��ȡServletCoontext����
	 * 2.��ServletContext�����л�ȡ��Ϊcount������
	 * 3.������ڣ�����������1��Ȼ�󱣴�
	 * 4.��������ڣ�˵���ǵ�һ�η��ʣ���ServletContext�б�����Ϊcount�����ԣ�ֵΪ1
	 * */
		ServletContext app=this.getServletContext();
		Integer count=(Integer)app.getAttribute("count");
		if(count==null) {
			app.setAttribute("count", 1);
		}else {
			app.setAttribute("count", count+1);
		}
		/*
		 * ����������
		 * ��Ҫʹ����Ӧ����
		 * */
		PrintWriter pw=response.getWriter();
		pw.print("<h1>"+count+"<h1>");
	}

}
