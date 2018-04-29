package aleph.ops.common.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aleph.ops.common.login.service.LoginService;

@Controller
public class LoginController {
	
	@ResponseBody
	@RequestMapping(value="/hello")
	public String sayHello() {
		return "Hello World of Spring !!";
	}

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/verifyUser", method=RequestMethod.POST)
	public String verifyUser(@RequestParam String name, 
							 @RequestParam String password,
							 ModelMap model) {
		LoginService loginService = new LoginService();
		if(!loginService.verifyUser(name,password)){
			model.addAttribute("errorMessage", "Invalid user");
			return "login";
		}
		
		model.addAttribute("name", name);
		return "welcome";
	}
}
