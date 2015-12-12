package team.dkh.pj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(BoardContorller.class);

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		logger.debug("i want login~~~");
		return "login";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model) {
		logger.debug("i want logut~~~");
		return "login";
	}
	
}
