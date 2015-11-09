package fi.siri.asiakas;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.siri.asiakas.Asiakas;
import fi.siri.asiakas.AsiakasDAO;

/* Kutsutaan suhteessa alkupolkuun, esim. 
  /Asiakaset/koneet/listaa
  /Asiakaset/kone/uusi
  /Asiakaset/kone/nimi
*/
@Controller
@RequestMapping(value = "/asiakkaat")
public class AsiakasController {

	// Injektoidaan standardi JPA:ta käyttävä AsiakasDAO komponentti

	@Inject
	// @Autowired
	private AsiakasDAO ap;


	// Lomakkeen luominen

	@RequestMapping(value = "/lomake", method = RequestMethod.GET)
	public String newForm(Model model) {
		Asiakas tk = new Asiakas();
		model.addAttribute("asiakas", tk);
		return "lomakeAsiakas";
	}

	// Lomakkeen tietojen ottaminen vastaan

	@RequestMapping(value = "/uusi", method = RequestMethod.POST)
	public String addNew(@Valid Asiakas ak, ModelMap model) {


		// tallennetaan lomakkeelta luettu kone
		Asiakas asiakas = ap.save(ak);
		model.addAttribute("asiakas", asiakas);
		return "uusiAsiakas";
	}

	// Kaikki Asiakkaat listattuna
	@RequestMapping(value = "/listaa",method = RequestMethod.GET)
	public String getAll(Model model) {
		System.out.println("*****Listaa asiakkaat *****");
		List<Asiakas> asiakkaat = ap.findAll();
		Asiakas as = new Asiakas();
		as.setNimi("Seija");
		as.setPuhelin("0405124362");
		asiakkaat.add(as);	
		ap.save(as);
		model.addAttribute("asiakkaat", asiakkaat);
		System.out.println("*****Asiakas sivulle*****");
		return "listaaAsiakkaat";
	}
	
}