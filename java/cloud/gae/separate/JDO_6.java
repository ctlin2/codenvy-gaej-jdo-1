package cloud.gae.separate;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cloud.gae.separate.jdoclasses.PMF;
import cloud.gae.separate.jdoclasses.Student;


@SuppressWarnings("serial")
public class JDO_6 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		// 做法一
		Query query = pm.newQuery(Student.class);
		query.setFilter("department == 'ME'");
		List<Student> students = (List<Student>) query.execute();

		for (Student each : students) {
			resp.getWriter().println(each.getName());
		}

		// 做法二
		Query query2 = pm.newQuery(Student.class);
		query2.setFilter("department == departmentParam");
		query2.declareParameters("String departmentParam");
		List<Student> students2 = (List<Student>) query2.execute("ME");

		for (Student each : students2) {
			resp.getWriter().println(each.getName());
		}

		pm.close();
	}
}
