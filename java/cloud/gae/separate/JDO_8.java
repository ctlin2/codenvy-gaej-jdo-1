package cloud.gae.separate;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cloud.gae.separate.jdoclasses.AddressInfo;
import cloud.gae.separate.jdoclasses.PMF;
import cloud.gae.separate.jdoclasses.Student;


@SuppressWarnings("serial")
public class JDO_8 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Student student = new Student("Harry", "B09807001", new GregorianCalendar(1990, 6, 7).getTime(), "CSIE");

		AddressInfo addressInfo = new AddressInfo("30012", "新竹市香山區五福路二段707號");
		student.setAddressInfo(addressInfo);

		try {
			pm.makePersistent(student);
		} finally {
			pm.close();
		}
	}
}
