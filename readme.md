# ѧ����Ϣ����ƽ̨����˵��
## ����

## С��ֹ�

6��

- ��̨
    - ���ݿ��������
        - entity��
        - DAO��
        - implement��
        - jdbcutil������
    - ��ǰ�˵Ĳ�������
        - servlet��
        - filter��
    - ��Ԫ����
- ǰ��
    - ȫ��ҳ��
        - ��¼ҳ��
        - �һ�����ҳ��
        - �޸�����ҳ��
    - ѧ��ҳ��
    - ��ʦҳ��
    - ����Աҳ��
    - ����Աҳ��


## ������и���Ŀ
��һ��������Ŀ��

���ʹ��IDEA��
1. ʹ��IDEA����ù���
2. ʹ��IDEA��λ����ɫ�ı���λ�ã�Alt+Enter��������Ҫ�İ���javax��Junit��
3. ����test���µ�FirstTest�ļ��������ܷ�����java������ܷ��������ݿ�
4. ����Tomcat(����ʹ�õ���8.5)����deployment������WebContentĿ¼ӳ��·��Ϊ/������Ĭ�Ϸ���Ŀ¼ΪWebContent
5. Ȼ�����http://localhost:8080/

���ʹ��Eclipse��
1. �ļ����������빤�̺󣬼���javax.servlet��junit��
2. �ļ�����С��涼��ʧ�ˣ�����Ŀͼ���ϻ���С��棺
�������˹����е�org.eclipse.wst.common.project.facet.core.xml�ļ��д���һ��<runtime>��ǩ�������������ض�����������µġ�
�����ж�����Tomcat�İ汾�������Ϊ�Լ�Tomcat�������İ汾�Ϳ����ˡ�
<runtime name="Apache Tomcat v8.5"/>
3. �������ݿ��ַ�Լ��û��������룬��c3p0-config.xml�ļ���
4. ����Tomcat�󡣷���http://localhost:8080/javaweb_project/login/login.jsp

## ��Ŀ�ṹ
���ݿ������

�����ײ��ļ���
	c3p0-config.xml
	JDBCUtils.java
	DAO.java

���ݿ����ӣ�
	c3p0���ӳ�
	
	JDBC2.0 �ṩ��javax.sql.DataSource�ӿڣ��������������ݿ�����ӣ�����Ӧ�ó����з������ݿ�ʱ 
	���ر�д�������ݿ�Ĵ��룬ֱ������DataSource��ȡ���ݿ�����Ӷ��󼴿ɡ����ڻ�ȡ��������Connection����


CURD����ɾ�Ĳ飩��

	ʹ�ü�JDBC�������������DBUtils

		DbUtils��(org.apache.commons.dbutils.DbUtils)��Ҫ����װ���������ر����ӵĳ��湤����
		QreryRunner��(org.apache.commons.dbutils.QueryRunner) �����ļ���SQL��ѯ������ResultSetHandlerЭͬ������ʹ��������Ϊ���١�
			update(Connection conn, String sql, Object... params)	���룬ɾ��������
           	query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params)	��ѯ
			
		ResultSetHandler�ӿ�(org.apache.commons.dbutils.ResultSethandler)ִ�д���һ����������󣬽�����ת�䲢����Ϊ�κ�һ����ʽ��������Ӧ��ʹ�á�
			BeanHandler: �ѽ����תΪһ�� Bean,������
			BeanListHandler: �ѽ����תΪһ�� Bean �� List, ������
			ScalarHandler: ���Է���ָ���е�һ��ֵ�򷵻�һ��ͳ�ƺ�����ֵ������count(1)��
			

implementʵ�ֲ㣺
����ʵ����̳�DAO�࣬�Ե���DAO���װ��CURD�ӿڣ����ڳ�ʼ���Ĺ����У���class����ֵ��DAO.clazz

���������14�ű��ʵ���࣬DAO�࣬ʵ���ࣺ

	cetgrade, 
	course, 
	courseschedule, 
	examarrange, 
	exemptionapply, 
	jwteacherinformation, 
	levelexam, 
	levelexamlist, 
	optionalcourse, 
	postponeexamapply, 
	studentbasicinformation, 
	studentgrade, 
	studentoptcourse, 
	teacherinformation, 
	users


web.xml
	welcome-file-list��һ��������web.xml�е�һ����ӭҳ��
	���ڵ��û���url�����빤�����ƻ�������web����url����http://localhost:8080/��ʱֱ����ת��ҳ��.

Servlet���Filter�㣺
�Ⱦ���Filter�ٵ���Servlet

Filter��������

�ڲ�ʹ��web.xml������Filter����ʹ��@WebFilterע��������Filterʱ������ͨ������filter���ļ���������filer��ִ��˳��

9�ֹ��ˣ�
0. HTTPFilter										�̳�Filter���Զ����������࣬���¶��̳иó�����

1. AcdemicDeanJspFilter		/acdemic_dean/*			���ʽ���Ա�û��µ�����ҳ��Ĺ���������session�е�user��ʧ������Ҫ���µ�¼
2. StudentFilter			/student/*				����ѧ���û��µ�����ҳ��Ĺ���������session�е�user��ʧ������Ҫ���µ�¼
3. TeacherFilter			/teacher/*				���ʽ�ʦ�û��µ�����ҳ��Ĺ���������session�е�user��ʧ������Ҫ���µ�¼
4. AdministratorJspFilter	/administrator/*		���ʹ���Ա�û��µ�����ҳ��Ĺ���������session�е�user��ʧ������Ҫ���µ�¼
	
5. LoginCheckCodeFilter		/loginChangeServlet		��¼ʱ���� ��֤���Ƿ�һ��
6. LoginFilter				/loginChangeServlet		��¼ʱ��֤�û����������Ƿ�������ȷ

7. EncodingFilter			/*						������������ַ���Ź�������ѡ��utf-8��
8. FindMMCheckCodeFilter	/findPasswordServlet	�һ�����ʱ�ж���֤��������ȷ
9. ModifyPasswordFilter		/modifyPasswordServlet	�޸�����ʱ���飺1.����������Ƿ���ȷ�� 2.������������ȷ�������Ƿ�һ��


servlet�㣺
20����

���ֱܷ�Ϊ��

1. loginChangeServlet			/loginChangeServlet		��¼ת�������ݲ�ͬ�û���ɫ�����ز�ͬ���û�����student.jsp/teacher.jsp/acdemic_dean.jsp/administrator.jsp
2. FindPasswordServlet			/findPasswordServlet	�һ����룬��������
3. ValidateColorServlet			/validateColorServlet	������֤��

4. LogoutServlet				/logoutServlet			�˳���¼�����ص�¼ҳ��login.jsp
5. ModifyPasswordServlet		/modifyPasswordServlet	�޸����룬���سɹ���Ϣ

studentҳ�棺

6. studentInformationServlet	/studentInformationServlet	�鿴ѧ����Ϣ������studentinformation.jsp

7. LevelExamServlet				*��apply					������Ϣ��ѯ�뿼������		
8. OptionalCourseServlet		*.optional				�γ���Ϣ��ѯ�뱨��

9. ExamArrangeServlet			/examArrangeServlet		�鿴���԰���
10. CourseScheduleServlet		/courseScheduleServlet	�鿴�γ̱�
11. PostponeExamapplyServlet	/PostponeExamapplyServlet	��������
12. ExemptionApplyServlet		/ExemptionApplyServlet		��������

13. CoursegradeServlet			*.grade(studentquery.grade)	ѧ����ѯ�Լ��ĳɼ������ز�ѯcoursegrade.jsp
14. LevelExaminationGradeServlet	studentquery.query		ѧ���Լ���ѯ�Լ��Ŀ����ɼ�������levelExaminationGrade.jsp


acdemic_deanҳ�棺

15. studentInformationServlet							����Ա¼��ѧ����ϢΪupdate,����insert


teacherҳ�棺


    ¼��ѧ���ɼ�bug��
    
    
    ����ͷ���������γ���Ϣ�鲻����
    ֻ�в��룬û�и��£��Ҳ����Ѿ����ڵĳɼ�Ҳ�ܳɹ�










