package com.software.dao;

import com.software.entity.Course;
public interface CourseQueryDAO {
	
	//public List<courseInfo> getAll();
	
	//public List<courseInfo> getAllcourse(Long teacherId);
	
	public Course get(String coursename);
	
	//public void insert(courseInfo courseSchedule);
	
	//public void update(courseInfo courseSchedule);
	
	//public void delete(String studentId);

	/**
	 * ���غ�studentId��ȵļ�¼��
	 * @param studentId
	 * @return
	 */
	//public long getCountWithName(String studentId);
	
	/**
	 * ���غ�studentId��yearTerm��week��ȵļ�¼
	 * @param studentId
	 * @param yearTerm
	 * @param week
	 * @return
	 */
	//public List<CourseSchedule> getAllWithYearTerm(String studentId, String yearTerm, String week);
	
	
	
}
