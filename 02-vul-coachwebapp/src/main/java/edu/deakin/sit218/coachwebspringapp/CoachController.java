package edu.deakin.sit218.coachwebspringapp;

import java.util.Random;
import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workout")
public class CoachController {

	@GetMapping
	public String workout(@RequestParam("studentName") String name, Model model) {
	
		
		model.addAttribute("name", name);
		
				Random r = new Random();
		if (r.nextBoolean())
			model.addAttribute("message", "No training today");
		else
			model.addAttribute("message", "Spend 30 min running");
		
return "workout";
}
}