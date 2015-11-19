package fi.javaee.siri.asiakas;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/myImage")
public class ImageController {

	@Inject
	// @Autowired
	private AsiakasDAO asiakasDAO;

	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") Integer asiakasId, HttpServletResponse response,
			HttpServletRequest request) throws ServletException, IOException {

		Asiakas a = asiakasDAO.findById((long) asiakasId);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(a.getValokuva());
		response.getOutputStream().close();
	}
}
