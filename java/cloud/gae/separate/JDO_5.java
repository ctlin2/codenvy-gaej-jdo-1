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
public class JDO_5 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query query = pm.newQuery(Student.class);
		List<Student> students = (List<Student>) query.execute();

		for (Student each : students) {
			String name = each.getName();
		}

		pm.close();
	}
}
