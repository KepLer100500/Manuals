package org.kepler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
// @RequestMapping("/user") <- this part of address put before all addresses
public class GreetingsController {

	@RequestMapping("/")
	public String showFirstView() {
		return "index";
	}

	@RequestMapping("/ask-name")
	public String getUserName() {
		return "ask-name";
	}

	@RequestMapping("/show-name")
	public String showUserName(HttpServletRequest request,
							   @RequestParam("nickName") String nickName,
							   Model model) {
		String userName = request.getParameter("userName"); // getParameter("userName") <- name in jsp page
		userName = "Mr. " + userName;
		model.addAttribute("updatedName", userName);
		model.addAttribute("nickName", nickName);
		return "show-name";
	}
}
