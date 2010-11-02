package net.raescott;

import java.io.InputStream;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Richard Scott Smith <rsmith@harriscomputer.com>
 */
public class ResultsController extends AbstractController {

	public ResultsController() {
		// Support http get and post right now.
		setSupportedMethods(new String[]{METHOD_GET, METHOD_POST});
		// Tell Browsers to cache this for 5 minutes.
		setCacheSeconds(300);
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		// Just populating the filename right now.
		String filename = request.getParameter("filename");
		modelAndView.addObject("filename", filename);

		// Now lets add the properties file loading.
		//InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		InputStream inputStream = getServletContext().getResourceAsStream(filename);
		//InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);

		System.out.println("filename: " + filename);
		System.out.println("inputStream: " + inputStream);

		// load the inputStream using the Properties
		Properties properties = new Properties();
		properties.load(inputStream);
		// get the value of the property
		String first = properties.getProperty("first");
		String last = properties.getProperty("last");

		modelAndView.addObject("first", first);
		modelAndView.addObject("last", last);

		// Let's add all the properties to the front end
		modelAndView.addObject("properties", properties);

		return modelAndView;
	}
}
