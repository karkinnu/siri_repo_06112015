package fi.javaee.siri.yritys;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/companies/list")
public class YritysController {

	@Inject
	// @Autowired
	private YritysDAO yritysDAO;

	// poista
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteGet(Model model, Long id) {
		yritysDAO.delete(id);
		List<Yritys> companies = yritysDAO.findAll();
		model.addAttribute("companies", companies);
		return "company_list";
	}

	// hae tiedot muutosta varten
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editGet(Model model, Long id) {
		Yritys yritys = yritysDAO.findById(id);
		model.addAttribute("yritys", yritys);
		return "company_edit";
	}

	// muuta
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editPost(@Valid Yritys yritys, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("yritys", yritys);
			return "company_edit";
		} else {
			yritysDAO.update(yritys);
		}

		List<Yritys> companies = yritysDAO.findAll();
		model.addAttribute("companies", companies);
		return "company_list";
	}

	// hae lomake lisaamista varten
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addGet(Model model) {
		Yritys yritys = new Yritys();
		model.addAttribute("yritys", yritys);
		return "company_add";
	}

	// lisaa
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(@Valid Yritys yritys, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("yritys", yritys);
			return "company_add";
		} else {
			Yritys y = yritysDAO.save(yritys);
		}

		List<Yritys> companies = yritysDAO.findAll();
		model.addAttribute("companies", companies);
		return "company_list";
	}

	// listaa kaikki
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Yritys> companies = yritysDAO.findAll();
		model.addAttribute("companies", companies);
		return "company_list";
	}

}
