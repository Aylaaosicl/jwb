package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��¼ת��
 * ��ȡ��¼�û�����Ϣ�����жϵ�¼�û������
 * �����û������ת����Ӧ���û�ҳ��
 * @author liqkjm
 *
 */
@WebServlet("/loginChangeServlet")
public class LoginChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath() + "/student/student.jsp");
		
	}
}
