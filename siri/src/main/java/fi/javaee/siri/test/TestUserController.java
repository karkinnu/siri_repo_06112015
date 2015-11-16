package fi.javaee.siri.test;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.javaee.siri.user.User;
import fi.javaee.siri.user.UserDAO;
import fi.javaee.siri.yritys.Yritys;
import fi.javaee.siri.yritys.YritysDAO;

@Controller
@RequestMapping(value = "/tu/list")
public class TestUserController {

	@Inject
	// @Autowired
	private UserDAO userDAO;

	// poista
    @RequestMapping(value="delete", method=RequestMethod.GET)
    public String deleteGet(Model model, Long id) {
    	userDAO.delete(id);
		List<User> users = userDAO.findAll();
		model.addAttribute("kayttajat", users);
		return "user_list";
    }

    // hae tiedot muutosta varten
    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String editGet(Model model, Long id) {
    	User user = userDAO.edit(id);
		model.addAttribute("user", user);
		return "user_edit";
    }

    // muuta
    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String editPost(@Valid User user, ModelMap model) {
    	userDAO.update(user);
    	List<User> users = userDAO.findAll();
		model.addAttribute("kayttajat", users);
		return "user_list";
    }

	// hae lomake lisaamista varten
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addGet(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user_add";
	}

	// lisaa
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(@Valid User user, ModelMap model) {
		// FIXME: User u = userDAO.save(user);
		List<User> users = userDAO.findAll();
		model.addAttribute("kayttajat", users);
		return "user_list";
	}

	// listaa kaikki
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<User> users = userDAO.findAll();
		model.addAttribute("yritykset", users);
		return "user_list";
	}

}
