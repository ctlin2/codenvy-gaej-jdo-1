package cloud.gae.separate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cloud.gae.separate.jdoclasses.PMF;
import cloud.gae.separate.jdoclasses.PhoneNumber;
import cloud.gae.separate.jdoclasses.Student;

@SuppressWarnings("serial")
public class JDO_9 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Student student = new Student("Tom", "B09807002", new GregorianCalendar(1991, 9, 15).getTime(), "CSIE");
		
		List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
		PhoneNumber home = new PhoneNumber("Home", "03-518XXX");
		PhoneNumber mobile = new PhoneNumber("Mobile", "0911XXXXXX");
		phoneNumbers.add(home);
		phoneNumbers.add(mobile);
		
		student.setPhoneNumbers(phoneNumbers);

		try {
			pm.makePersistent(student);
		} finally {
			pm.close();
		}
	}
}
