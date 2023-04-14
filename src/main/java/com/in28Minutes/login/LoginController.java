package com.in28Minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("name")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", "in28Minutes");
		return "welcome";
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
