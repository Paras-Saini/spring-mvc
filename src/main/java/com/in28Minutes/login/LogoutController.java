package com.in28Minutes.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@SessionAttributes("name")
public class LogoutController {

	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		request.getSession().invalidate();
		return "redirect:/";
	}
}






/*package com.in28Minutes.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("name")
public class LoginController {
	
	
	/*@Autowired
	LoginService service;*/

	//@RequestMapping(value="/", method=RequestMethod.GET)
	//@ResponseBody
	//public String WelcomeController(ModelMap model) {
		//model.put("name","in28Minutes");
		//return "welcome";
	//}
	

	/*@RequestMapping(value="/login", method=RequestMethod.POST)
	//@ResponseBody
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(!service.validateUser(name, password)) {
			model.put("errorMessage","Invalid Credentials");
			return "login";
		}
			
		
		
		model.put("name", name);
		return "welcome";
		
		
	}*/
	
//}
