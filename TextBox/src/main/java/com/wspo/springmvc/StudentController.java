package com.wspo.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Component
public class StudentController {

	   @Autowired
	   @Qualifier("studentValidator")
	   private Validator validator;

	   @InitBinder
	   private void initBinder(WebDataBinder binder) {
	      binder.setValidator(validator);
	   }

	   @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("addStudent", "student", new Student());
	   }

	   @ModelAttribute("student")
	   public Student createStudentModel() {    
	      return new Student();
	   }

	   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("student") @Validated Student student, 
	      BindingResult bindingResult, Model model) {

	      if (bindingResult.hasErrors()) {
	         return "addStudent";
	      }
	      model.addAttribute("name", student.getName());
	      model.addAttribute("age", student.getAge());
	      model.addAttribute("id", student.getId());

	      return "result";
	   }
}