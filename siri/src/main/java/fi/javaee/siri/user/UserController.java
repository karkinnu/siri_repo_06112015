package fi.javaee.siri.user;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Controller
@RequestMapping(value = "/users")  
public class UserController {
	@Inject
	// @Autowired
	private UserDAO up;


	// Login lomakkeen luominen
	@RequestMapping( method = RequestMethod.GET)
	public String users(Model model) {
		return "admin";
	}

	// Login lomakkeen luominen
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		up.deleteUser("Dummy");
		User x = new User("Dummy", "Dummy", true);
		up.saveUser(x);
		System.out.println("*****login *****");
		User u = new User();
		model.addAttribute("user", u);
		return "login";
	}

	// Käyttäjän tunnistus

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String checkUser( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
		System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
		String nextPage = "main";
		User user2 = up.findByUserName(user.getUsername());

		StandardPasswordEncoder encoder = new StandardPasswordEncoder();				

		if (user2!=null){
			if ( encoder.matches(user.getPassword(), user2.getPassword() ) ){  // kirjoitettu ss, taulusta kryptattu ss

			}
			else{		
				//model.addAttribute("error", "Invalid password");
				nextPage = "403";
			}
		}
		else {
			//model.addAttribute("error", "User not found");
			nextPage="403";
		}
		return nextPage;
	}

	// Logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutForm(Model model) {
		System.out.println("*****logout *****");
		return "welcome";
	}

	// Käyttäjän lisäys
	@RequestMapping(value = "/add", method = RequestMethod.GET)	
	public String addUserForm( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
		System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
		return "userAdd";
	}

	// Käyttäjän lisäys
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
		User user3 = up.findByUserName(user.getUsername());
		if(user3 == null){
			System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
			up.saveUser(user);
		}
		return "admin";

	}

	// Käyttäjän poisto
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removeUserForm( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
		System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
		return "userRemove";
	}

	// Käyttäjän poisto
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeUser( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
		System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());	
		up.deleteUser(user.getUsername());
		return "admin";
	}
}
