package uc.exp.bremen.solaradaptor.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController extends BaseController{

	@GetMapping(value = "/index", produces = MediaType.TEXT_HTML_VALUE)
	public String home(Model model) {

		var words = List.of("Lina", "Bahir", "Assegd", "river", "SOLARADAPTOR");

		model.addAttribute("words", words);

		return "index";
	}
}
