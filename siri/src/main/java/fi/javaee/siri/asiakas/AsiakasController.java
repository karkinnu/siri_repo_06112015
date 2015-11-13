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

	// Injektoidaan standardi JPA:ta käyttävä AsiakasDAO komponentti

	@Inject
	// @Autowired
	private AsiakasDAO ap;

    @RequestMapping(value="delete", method=RequestMethod.GET)
    public String delete(Model model, Long id) {
    	ap.delete(id);
		List<Asiakas> asiakkaat = ap.findAll();
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
    }

    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String editGet(Model model, Long id) {
    	Asiakas asiakas = ap.edit(id);
		model.addAttribute("asiakas", asiakas);
		return "customer_edit";
    }

   @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(@Valid Asiakas asiakas, ModelMap model) {
   		ap.update(asiakas);
    	List<Asiakas> asiakkaat = ap.findAll();
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
    }

	// Lomakkeen luominen
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String newForm(Model model) {
		Asiakas tk = new Asiakas();
		model.addAttribute("asiakas", tk);
		return "customer_form";
	}

	// Lomakkeen tietojen ottaminen vastaan

	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String addNew(@Valid Asiakas ak, ModelMap model) {
		// tallennetaan lomakkeelta luettu kone
		Asiakas asiakas = ap.save(ak);
		//model.addAttribute("asiakas", asiakas);
		List<Asiakas> asiakkaat = ap.findAll();
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
	}

	// Kaikki Asiakkaat listattuna
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Asiakas> asiakkaat = ap.findAll();
//		Asiakas as = new Asiakas();
//		as.setNimi("Seija");
//		as.setPuhelin("0405124362");
//		asiakkaat.add(as);	
//		ap.save(as);
		model.addAttribute("asiakkaat", asiakkaat);
		return "customer_list";
	}
	
}
