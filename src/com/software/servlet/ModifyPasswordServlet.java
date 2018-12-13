package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.entity.User;
import com.software.impl.UserDAOImpl;

@WebServlet("/modifyPasswordServlet")
public class ModifyPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String newpassword = request.getParameter("newpassword");
	
		//�޸�����
		update(user,newpassword);
		session.setAttribute("message", "�޸�����ɹ�");
		response.sendRedirect(request.getContextPath() + "/modify/modifypassword.jsp");
	}

	private void update(User user, String newpassword) {
		UserDAOImpl u = new UserDAOImpl();
		
		user.setPassword(newpassword);
		u.update(user);
	}

}
