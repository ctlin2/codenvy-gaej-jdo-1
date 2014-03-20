package cloud.gae.separate;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cloud.gae.separate.jdoclasses.PMF;
import cloud.gae.separate.jdoclasses.Student;


@SuppressWarnings("serial")
public class JDO_1 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Student student = new Student("Kevin", "B09910001", new GregorianCalendar(1990, 5, 4).getTime(), "ME");

		try {
			pm.makePersistent(student);
		} finally {
			pm.close();
		}
	}
}