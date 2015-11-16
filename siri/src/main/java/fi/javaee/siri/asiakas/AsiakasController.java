package fi.javaee.siri.asiakas;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String editPost(@Valid Asiakas asiakas, ModelMap model) {
		asiakasDAO.update(asiakas);
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
	public String addPost(@Valid Asiakas asiakas, ModelMap model) {
		Asiakas a = asiakasDAO.save(asiakas);
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
