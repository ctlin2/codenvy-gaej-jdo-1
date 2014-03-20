package cloud.gae.separate;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cloud.gae.separate.jdoclasses.PMF;
import cloud.gae.separate.jdoclasses.Student;


@SuppressWarnings("serial")
public class JDO_3 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Student student = pm.getObjectById(Student.class, "B09903001");
		student.setDepartment("CSIE");

		try {
			pm.makePersistent(student);
		} finally {
			pm.close();
		}
	}
}
