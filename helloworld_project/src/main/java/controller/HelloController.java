package controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HelloController {
	@RequestMapping("/hello")
	private String init(Model model) {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//Principalからログインユーザの情報を取得
		String userName = auth.getName();
		model.addAttribute("userName", userName);
		return "hello";
}
}
