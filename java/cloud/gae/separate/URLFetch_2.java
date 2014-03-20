package cloud.gae.separate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

@SuppressWarnings("serial")
public class URLFetch_2 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		URLFetchService service = URLFetchServiceFactory.getURLFetchService();
		try {
			HTTPResponse httpresp = service.fetch(new URL("http://code.google.com/appengine/images/appengine_lowres.png"));
			resp.setContentType("image/png");
			resp.getOutputStream().write(httpresp.getContent());

		} catch (MalformedURLException e) {
			// ...
		} catch (IOException e) {
			// ...
		}
	}
}
