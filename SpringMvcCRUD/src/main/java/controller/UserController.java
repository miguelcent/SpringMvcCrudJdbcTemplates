package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView list(){
		
		ModelAndView model = new ModelAndView("user/user_page");
				
		List<User> list = userService.listAllUsers();
		model.addObject("listUser", list);
				
		return model;
		
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView add(){
		
		ModelAndView model = new ModelAndView("user/user_form");
						
		User user = new User();
		model.addObject("userForm", user);
				
		return model;
		
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id){
		
		ModelAndView model = new ModelAndView("user/user_form");
						
		User user = userService.findUserById(id);
		model.addObject("userForm", user);
				
		return model;
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("userFrom") User user){
								
		if(user != null && user.getId() != null){
			//update
			userService.updateUser(user);
		} else {
			//add
			userService.addUser(user);
		}
				
		return new ModelAndView("redirect:/list");
		
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id){
			 			
		userService.deleteUser(id);
		return new ModelAndView("redirect:/list");
		
	}
	
}
