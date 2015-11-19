package fi.javaee.siri.asiakas;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fi.javaee.siri.yritys.Yritys;

@Controller
@RequestMapping(value = "/customers/list")
public class AsiakasController {

	@Inject
	// @Autowired
	private AsiakasDAO asiakasDAO;

	// poista
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteGet(Model model, Long id) {
		asiakasDAO.delete(id);
		List<Asiakas> asiakkaat = asiakasDAO.findAll();
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
	}

	// hae tiedot muutosta varten
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editGet(Model model, Long id) {
		Asiakas asiakas = asiakasDAO.findById(id);
		model.addAttribute("asiakas", asiakas);
		return "customer_edit";
	}

	// muuta
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editPost(@Valid Asiakas asiakas, BindingResult result, ModelMap model,
			@RequestParam("valokuvafile") MultipartFile file) {

		try {
			byte[] bytes = file.getBytes();
			if (bytes.length == 0) {
				Asiakas a = asiakasDAO.findById((long) asiakas.getAsiakasId());
				asiakas.setValokuva(a.getValokuva());
			} else
				asiakas.setValokuva(bytes);
		} catch (Exception e) {
			System.out.println("Valokuvan lataus ei onnistunut");
		}
		if (result.hasErrors()) {
			System.out.println("edit: error has been found");
			model.addAttribute("asiakas", asiakas);
			return "customer_edit";
		} else {
			System.out.println("edit: no error");
			asiakasDAO.update(asiakas);
		}

		List<Asiakas> asiakkaat = asiakasDAO.findAll();
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
	}

	// hae lomake lisaamista varten
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addGet(Model model) {
		Asiakas asiakas = new Asiakas();
		model.addAttribute("asiakas", asiakas);
		return "customer_add";
	}

	// lisaa
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(@Valid Asiakas asiakas, BindingResult result, ModelMap model,
			@RequestParam("valokuvafile") MultipartFile file) {
		try {
			byte[] bytes = file.getBytes();
			if (bytes.length != 0)
				asiakas.setValokuva(bytes);
		} catch (Exception e) {
			System.out.println("Valokuvan lataus ei onnistunut");
		}

		if (result.hasErrors()) {
			System.out.println("add: error has been found");
			model.addAttribute("asiakas", asiakas);
			return "customer_add";
		} else {
			System.out.println("add: no error");
			Asiakas a = asiakasDAO.save(asiakas);
		}

//		model.addAttribute("asiakas", asiakas);
//		return "customer_add";

		List<Asiakas> asiakkaat = asiakasDAO.findAll();
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
	}

	// listaa kaikki
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Asiakas> asiakkaat = asiakasDAO.findAll();
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
	}

}
