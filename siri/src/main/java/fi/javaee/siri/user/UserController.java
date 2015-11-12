package fi.javaee.siri.user;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
			System.out.println("*****login *****");
			User u = new User();
			model.addAttribute("user", u);
			return "login";
		}

		// Lomakkeen tietojen ottaminen vastaan

		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String checkUser(@Valid User user, ModelMap model) {
			String nextPage = "/user/main";
			User u = up.findByUserName(user.getUsername());
			if (u!=null){
				if (u.getPassword().equals(user.getPassword())){
					
				}
				else{		
					model.addAttribute("error", "Invalid password");
					nextPage = "403";
				}
			}
			else {
				model.addAttribute("error", "User not found");
				nextPage="403";
			}
			return nextPage;
		}
		
		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logoutForm(Model model) {
			System.out.println("*****logout *****");
			return "welcome";
		}
}
