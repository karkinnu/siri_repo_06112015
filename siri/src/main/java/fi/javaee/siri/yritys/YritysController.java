package fi.javaee.siri.yritys;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.javaee.siri.asiakas.Asiakas;

@Controller
@RequestMapping(value = "/companies")
public class YritysController {

	// Injektoidaan standardi JPA:ta käyttävä AsiakasDAO komponentti

	@Inject
	// @Autowired
	private YritysDAO yp;


	
	// Lomakkeen luominen
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String newForm(Model model) {
		System.out.println("GET");
		Yritys yritys = new Yritys();
		model.addAttribute("company", yritys);
		return "/company/formCompany";
	}

	// Lomakkeen tietojen ottaminen vastaan
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String addNew(@Valid Yritys yr, ModelMap model) {
		System.out.println("POST");
		// tallennetaan lomakkeelta luettu kone
		Yritys yritys = yp.save(yr);

		List<Yritys> yritykset = yp.findAll();
		model.addAttribute("companies", yritykset);
		return "/company/companies";
	}

	// Kaikki Asiakkaat listattuna
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Yritys> yritykset = yp.findAll();
//		Yritys yritys1 = new Yritys();
//		yritys1.setNimi("Yritys A");
//		yritys1.setPuhelin("123");
//		yritykset.add(yritys1);	
//		yp.save(yritys1);
//		Yritys yritys2 = new Yritys();
//		yritys2.setNimi("Yritys B");
//		yritys2.setPuhelin("456");
//		yritykset.add(yritys2);	
//		yp.save(yritys2);
		model.addAttribute("companies", yritykset);
		return "/company/companies";
	}
	
}
