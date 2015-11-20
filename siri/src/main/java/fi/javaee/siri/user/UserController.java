package fi.javaee.siri.user;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.log4j.Logger;


@Controller
@RequestMapping(value = "/users/list")
public class UserController {
	@Inject
	private UserDAO userDAO;

	final static Logger logger = Logger.getLogger(UserController.class);
	
	// poista
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteGet(Model model, Long id) {
		userDAO.delete(id);
		List<User> users = userDAO.findAll();
		model.addAttribute("kayttajat", users);
		return "user_list";
	}

	// hae tiedot muutosta varten
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editGet(Model model, Long id) {
		User kayttaja = userDAO.findById(id);
		model.addAttribute("user", kayttaja);
		return "user_edit";
	}

	// muuta
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editPost(@Valid User user, BindingResult result, ModelMap model) {

		if (!user.getNewPassword().isEmpty()) {
			user.setPassword(user.getNewPassword());
		}

		if (result.hasErrors()) {
			logger.error("add: error has been found in edit");
			model.addAttribute("user", user);
			return "user_edit";
		} else {
			userDAO.update(user);
		}

		List<User> yritykset = userDAO.findAll();
		model.addAttribute("kayttajat", yritykset);
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
	public String addPost(@Valid User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.error("add: error has been found");
			model.addAttribute("user", user);
			return "user_add";
		} else {
			User u = userDAO.saveUser(user);
		}

		List<User> kayttajat = userDAO.findAll();
		model.addAttribute("kayttajat", kayttajat);
		return "user_list";
	}

	// listaa kaikki
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<User> kayttajat = userDAO.findAll();
		model.addAttribute("kayttajat", kayttajat);
		
		
		int parameter = 1;		
		logger.info("This is info. Test that logger is working: " + parameter);
		
		return "user_list";
	}

}
