package fi.siri.asiakas;


import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* Kutsutaan suhteessa alkupolkuun, esim. 
  /tietokoneet/koneet/listaa
  /tietokoneet/kone/uusi
  /tietokoneet/kone/nimi
*/
@Controller
@RequestMapping(value = "/")
public class SiriController {


	// Kaikki tietokoneet listattuna
	@RequestMapping(method = RequestMethod.GET)
	public String start(Model model) {
		System.out.println("*****Siri pääsivulle*****");
		return "index";
	}
}
