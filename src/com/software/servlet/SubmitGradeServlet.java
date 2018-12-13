package com.software.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.CourseQueryDAO;
import com.software.dao.StudentGradeDAO;
import com.software.entity.StudentGrade;
import com.software.entity.Course;
import com.software.impl.CourseQueryDAOImpl;
import com.software.impl.StudentGradeDAOIpml;

@WebServlet("/submitGradeServlet/*")
public class SubmitGradeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CourseQueryDAO courseQueryDAO = new CourseQueryDAOImpl();
	private StudentGradeDAO studentGradeDAO = new StudentGradeDAOIpml();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.��ȡrequestUrI
		// String servletPath = request.getServletPath();
		// String contextPath = request.getContextPath();
		String requestUrI = request.getRequestURI();
		// 2.��ȡ�����insert/update
		String methodName = requestUrI.substring(36, requestUrI.length());
		// System.out.println(methodName);
		HttpSession session = request.getSession();
		Long studentid = Long.parseLong(request.getParameter("studentnumber"));
		String studentname = request.getParameter("studentname");
		String coursename = request.getParameter("coursename");
		Integer grade = Integer.parseInt(request.getParameter("grade"));

		/*FIXME course��鲻���������޸�*/
		// ���ݿγ����ֲ����Ӧ�Ŀγ���Ϣ:�γ�Id���γ�ѧ�֣��γ����ͣ��γ���ϰ��ʽ
		//courseInfo courseResult = courseQueryDAO.get(coursename);
		
		// û�в��ҵ��γ̣���˵��û����ڿ�
		if(grade > 1000 || grade < 0) {
			session.setAttribute("message", "�������");
			
		} else{
			// ��ѯ�ÿγ̵ĳɼ��Ƿ���ڣ���ʱĬ�ϸóɼ�������
			String courseid = "HFP1805";//courseResult.courseid;//�γ�ID
			Double credit = 4.0;//courseResult.credit;
			String studyway = "רҵѡ�޿�";//courseResult.studyway;// �γ����
			String classType = "ѡ��";//courseResult.classtype;
			
			
			Double gradepoint = ((double) grade / 10) - 6.0;// ���ݳɼ�����
			gradepoint = (double) Math.round(gradepoint * 10) / 10;
			//Double  = grade / 100 * credit;
			// �̶�
			String yearTerm = "2018����";
			String examway = "��������";
			String gradeway = "�ٷ���";
			String effectivity = "1";
			String remarks = "";
			
			StudentGrade studentGrade = new StudentGrade(yearTerm, studentid, studentname, courseid, coursename, grade, gradepoint,
					credit, classType, studyway, examway, gradeway, effectivity, remarks);	
			
			try {
				if(methodName.equals("insert")) {
					insert(studentGrade);
					session.setAttribute("message", "¼��ɹ�");
				} else {
					update(studentGrade);
					session.setAttribute("message", "�޸ĳɹ�");
				}
			} catch(Exception e) {
				e.printStackTrace();
				session.setAttribute("message", "�޸�ʧ��");
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/teacher/grademanagement/insertgrade.jsp");
	}

	private void insert(StudentGrade studentGrade) throws IOException {
		studentGradeDAO.insert(studentGrade);
	}

	private void update(StudentGrade studentGrade) throws IOException {
		
		// ����ԭ����Ϣ��ֻ���³ɼ��ͼ���������Ϣ
		StudentGrade newStudentGrade = studentGradeDAO.get(studentGrade.getStudentId(),studentGrade.getCourseName());
		
		newStudentGrade.setGradePoint(studentGrade.getGradePoint());
		newStudentGrade.setScore(studentGrade.getScore());
		
		studentGradeDAO.updateByStudentIdAndCourseName(newStudentGrade);
	}
}
