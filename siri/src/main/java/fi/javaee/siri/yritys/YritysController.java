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
@RequestMapping(value = "/companies/list")
public class YritysController {

	private Yritys origYritys = null;

	// Injektoidaan standardi JPA:ta käyttävä AsiakasDAO komponentti

	@Inject
	// @Autowired
	private YritysDAO yp;

    @RequestMapping(value="delete", method=RequestMethod.GET)
    public String delete(Model model, Long id) {
        System.out.println("Delete:" + id);
    	yp.delete(id);

		List<Yritys> yritykset = yp.findAll();
		model.addAttribute("companies", yritykset);
		return "company_list";
    }

    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String editGet(Model model, Long id) {
        System.out.println("Edit get:" + id);
    	Yritys yritys = yp.edit(id);
    	origYritys = yritys;
        System.out.println("orig:" + origYritys);
		model.addAttribute("company", yritys);
		return "company_edit";
    }

   @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(@Valid Yritys yr, ModelMap model) {
		System.out.println("Edit post:" + yr.getNimi());
		yr.setYritysId(origYritys.getYritysId());
   		yp.update(origYritys, yr);

    	List<Yritys> yritykset = yp.findAll();
		model.addAttribute("companies", yritykset);
		return "company_list";
    }

	// Lomakkeen luominen
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String newForm(Model model) {
		System.out.println("Get:" + model.toString());
		Yritys yritys = new Yritys();
		model.addAttribute("company", yritys);
		return "company_form";
	}

	// Lomakkeen tietojen ottaminen vastaan
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String addNew(@Valid Yritys yr, ModelMap model) {
		System.out.println("Post:" + yr.getNimi());
		// tallennetaan lomakkeelta luettu kone
		Yritys yritys = yp.save(yr);

		List<Yritys> yritykset = yp.findAll();
		model.addAttribute("companies", yritykset);
		return "company_list";
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
		return "company_list";
	}

}
