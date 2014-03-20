package cloud.gae.separate;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cloud.gae.separate.jdoclasses.PMF;
import cloud.gae.separate.jdoclasses.Student;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class JDO_2 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Student student = new Student("Jeff", "B09903001", new GregorianCalendar(1990, 3, 18).getTime(), "EE");
		String studentNo = student.getStudentNo();

		Key key = KeyFactory
				.createKey(Student.class.getSimpleName(), studentNo);
		student.setKey(key);

		try {
			pm.makePersistent(student);
			Student student2 = pm.getObjectById(Student.class, studentNo);
		} finally {
			pm.close();
		}
	}
}
