//package info.helloworld.sbmt.controller;
//
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class HelloController {
//
//	@RequestMapping("/hello")
//	private String init(Model model) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		// Principalからログインユーザの情報を取得
//		String userName = auth.getName();
//		model.addAttribute("userName", userName);
//		return "hello";
//
//	}
//}
