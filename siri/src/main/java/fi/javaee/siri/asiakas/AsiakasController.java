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
		Asiakas asiakas = asiakasDAO.edit(id);
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
	public String addPost(@Valid Asiakas ak, ModelMap model) {
		// tallennetaan lomakkeelta luettu kone
		Asiakas asiakas = asiakasDAO.save(ak);
		// model.addAttribute("asiakas", asiakas);
		List<Asiakas> asiakkaat = asiakasDAO.findAll();
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
	}

	// listaa kaikki
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		// Asiakas as = new Asiakas();
		// as.setNimi("Seija");
		// as.setPuhelin("0405124362");
		// asiakkaat.add(as);
		// ap.save(as);
		List<Asiakas> asiakkaat = asiakasDAO.findAll();
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
	}

}
