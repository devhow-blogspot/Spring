package com.devhow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.devhow.dto.TouristDto;
import com.devhow.model.Tourist;
import com.devhow.service.TouristService;

@Controller
public class TouristController {

	@Autowired
	private TouristService touristService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexPage(){
		ModelAndView mv = new ModelAndView("index");
		TouristDto form = new TouristDto();
		mv.addObject("searchTouristCommand", form);
		return mv;
	}
	

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerTourist() {
		ModelAndView mv = new ModelAndView("register");
		TouristDto form = new TouristDto();
		mv.addObject("touristForm", form);
		return mv;
	}

	@RequestMapping(value = "/addTourist", method = RequestMethod.POST)
	public ModelAndView addNewTourist(
			@ModelAttribute("touristForm") TouristDto touristForm,
			BindingResult bindResult) {
		ModelAndView mv = new ModelAndView("viewTourist");
		TouristDto dtoSaved = this.touristService.save(touristForm);
		mv.addObject("tourist", dtoSaved);
		mv.addObject("message", "Tourist created succesfully");
		return mv;
	}

	@RequestMapping(value = "/listTourists", method = RequestMethod.GET)
	public ModelAndView listTourists() {
		List<Tourist> list = this.touristService.getAll();
		ModelAndView mv = new ModelAndView("listTourists");
		mv.addObject("list", list);

		return mv;
	}
	
	@RequestMapping(value="/searchTourist", method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute("searchTouristCommand") TouristDto searchTouristCommand,	BindingResult bindResult){
		ModelAndView mv = new ModelAndView("listTourists");
		List<Tourist> list = this.touristService.searchByLastName(searchTouristCommand.getLastName());
		mv.addObject("list", list);
		return mv;
	}

}
