package fi.javaee.siri.asiakas;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
	final static Logger logger = Logger.getLogger(AsiakasController.class);


	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	public void showImage(@RequestParam("id") Integer asiakasId, HttpServletResponse response,
			HttpServletRequest request) throws ServletException, IOException {
		
		Asiakas a = asiakasDAO.findById((long) asiakasId);
		logger.info("ImageController : ImageDisplay");

		if ( a.getValokuva() == null ){
			logger.info("ImageController : ImageDisplay : kuvafile 0");
			//File myFile=new File("/resources/images/images.jpeg");
			URL url = new URL("https://pixabay.com/static/uploads/photo/2014/10/18/22/26/squirrel-493790_640.jpg");
			BufferedImage image = ImageIO.read(url);			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);
			baos.flush();
			byte [] imageInByte = baos.toByteArray();
			a.setValokuva(imageInByte);
		}
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(a.getValokuva());
		response.getOutputStream().close();
	}
}
