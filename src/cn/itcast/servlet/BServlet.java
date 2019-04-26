package cn.itcast.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;


@WebServlet("/BServlet")
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.得到ClassLoader
		 * 2.得到其getResourceAsStream(),得到一个InputStream
		 * */
		ClassLoader c1=this.getClass().getClassLoader();
		InputStream input=c1.getResourceAsStream("D:\\cloud.png");
		
		String s=IOUtils.toString(input);//读取内容，转换成字符串返回
		System.out.println(s);
	}

}
