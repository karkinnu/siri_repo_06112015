package fi.javaee.siri.user;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.javaee.siri.yritys.Yritys;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Controller
@RequestMapping(value = "users/list")  
public class UserController {
	@Inject
	// @Autowired
	private UserDAO userDAO;

//	// Login lomakkeen luominen
//	@RequestMapping(method = RequestMethod.GET)
//	public String users(Model model) {
//		return "admin";
//	}

//	// Login lomakkeen luominen
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String loginForm(Model model) {
//		userDAO.deleteUser("Dummy");
//		User x = new User("Dummy", "Dummy", true);
//		userDAO.saveUser(x);
//		System.out.println("*****login *****");
//		User u = new User();
//		model.addAttribute("user", u);
//		return "login";
//	}
//
//	// Käyttäjän tunnistus
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String checkUser( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
//		System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
//		String nextPage = "main";
//		User user2 = userDAO.findByUserName(user.getUsername());
//
//		StandardPasswordEncoder encoder = new StandardPasswordEncoder();				
//
//		if (user2!=null){
//			if ( encoder.matches(user.getPassword(), user2.getPassword() ) ){  // kirjoitettu ss, taulusta kryptattu ss
//
//			}
//			else{		
//				//model.addAttribute("error", "Invalid password");
//				nextPage = "403";
//			}
//		}
//		else {
//			//model.addAttribute("error", "User not found");
//			nextPage="403";
//		}
//		return nextPage;
//	}

//	// Logout
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logoutForm(Model model) {
//		System.out.println("*****logout *****");
//		return "welcome";
//	}

//    // hae lomake lisaamista varten
//	@RequestMapping(value = "add", method = RequestMethod.GET)	
//	public String addUserForm( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
//		System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
//		return "user_add";
//	}
//
//	// lisaa
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String addUser( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
//		User u = userDAO.findByUserName(user.getUsername());
//		if(u == null){
//			System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
//			userDAO.saveUser(user);
//		}
//		return "user_list";
//
//	}
//
//	// Käyttäjän poisto
//	@RequestMapping(value = "/remove", method = RequestMethod.GET)
//	public String removeUserForm( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
//		System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
//		return "userRemove";
//	}
//
//	// Käyttäjän poisto
//	@RequestMapping(value = "/remove", method = RequestMethod.POST)
//	public String removeUser( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
//		System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());	
//		userDAO.deleteUser(user.getUsername());
//		return "admin";
//	}

	// listaa kaikki
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String getAll(Model model) {
//		List<User> kayttajat = userDAO.findAll();
//		model.addAttribute("kayttajat", kayttajat);
//		return "user_list";
//	}

	// poista
    @RequestMapping(value="delete", method=RequestMethod.GET)
    public String deleteGet(Model model, Long id) {
    	System.out.println("id = " + id);
    	userDAO.delete(id);
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

    // hae tiedot muutosta varten
    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String editGet(Model model, Long id) {
    	User kayttaja = userDAO.edit(id);
		model.addAttribute("user", kayttaja);
		return "user_edit";
    }

    // muuta
    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String editPost(@Valid User kayttaja, ModelMap model) {
    	userDAO.update(kayttaja);
    	List<User> yritykset = userDAO.findAll();
		model.addAttribute("kayttajat", yritykset);
		return "user_list";
    }

	// lisaa
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(@Valid User user, ModelMap model) {
		User u = userDAO.saveUser(user);
		List<User> kayttajat = userDAO.findAll();
		model.addAttribute("kayttajat", kayttajat);
		return "user_list";
	}

	// listaa kaikki
	// FIXME: asiakas ja yritys puolella on
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// mutta tässä ei voi olla value:ta, ei vaan ..tana toimi jos on!
	@RequestMapping(method = RequestMethod.GET)
	public String users(Model model) {
		List<User> kayttajat = userDAO.findAll();
		model.addAttribute("kayttajat", kayttajat);
		return "user_list";
	}

}
