package fi.javaee.siri.user;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Inject
	// @Autowired
	private UserDAO up;
	
	// Lomakkeen luominen
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

		// Lomakkeen tietojen ottaminen vastaan

		@RequestMapping(value = "/login", method = RequestMethod.POST)
		
		public String checkUser( @ModelAttribute(value="user") @Valid User user, BindingResult result) {
		
		//public String checkUser(@Valid User user, ModelMap model) {
			System.out.println("Username: "+user.getUsername()+ " password: "+user.getPassword());
			String nextPage = "main";
			User user2 = up.findByUserName(user.getUsername());
			if (user2!=null){
				if (user2.getPassword().equals(user.getPassword())){
					
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

}
