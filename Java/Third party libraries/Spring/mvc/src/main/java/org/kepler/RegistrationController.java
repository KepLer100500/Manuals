package org.kepler;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import javax.validation.Valid;


@Controller
public class RegistrationController {

	@RequestMapping("/registration")
	public String registrationUser(Model model) {
		User defaultUser = new User();
		defaultUser.setName("user");
		defaultUser.setAge(20);
		defaultUser.setDepartment("IT 404");
		defaultUser.setSubDepartment("Otdel3");
		
		model.addAttribute("user", defaultUser);
		return "registration";
	}

	@RequestMapping("/registration-info")
	public String showRegistrationUserInfo(@Valid @ModelAttribute("user") User user, 
		BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "registration";
		} 
		user.setName("Mr. " + user.getName());
		user.setPass("Secret");
		return "registration-info";
		
	}
}
