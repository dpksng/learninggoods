package com.learninggoods.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.learninggoods.dao.entity.User;
import com.learninggoods.dao.impl.UserDaoImpl;
import com.learninggoods.services.DateTime;

@Controller
@SessionAttributes(value = {"su"})
public class UserController {
	
	@Autowired
	private UserDaoImpl ui;
	
	@Autowired
	private DateTime dt;
	
	@RequestMapping(value=("/performLogin"),method=RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request,User user){
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		user=ui.getUserByEmail(email);
		String confirm=user.getPwd();
		if(password.equals(confirm)){
			ModelAndView m=new ModelAndView("redirect:/default");
			m.addObject("su",user);
			return m;
		}else{
			ModelAndView m=new ModelAndView("redirect:/");
			return m; 
		}
	}
	
	@RequestMapping("/userLogout")
    public ModelAndView userLogout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
       ModelAndView m=new ModelAndView("redirect:/");
       return m;
    }
	
	@RequestMapping(value="/forgot-password")
	public ModelAndView forgotPassword(){
		ModelAndView m=new ModelAndView("forgot-password");
		return m;
	}
	
	@RequestMapping(value="/accountRecovery",method=RequestMethod.POST)
	public ModelAndView recoverAccount(@ModelAttribute("user")User user,HttpServletRequest request){
		
		String check=request.getParameter("email");
		user=ui.getUserByEmail(check);
		
		if(user.getId()!=null) {
			ModelAndView m=new ModelAndView("account-recovery");
			m.addObject("recover",user);
			return m;
		}
		else{
			ModelAndView m=new ModelAndView("redirect:/forgot-password");
			m.addObject("msg","Email not found");
			return m;
		}
	}
	
	@RequestMapping(value="/createPassword")
	public ModelAndView createPassword(User user){
		
		String email=user.getEmail().trim();
		String answer1=user.getAnswer1().trim();
		String answer2=user.getAnswer2().trim();
		String dob=user.getDob();
		
		User usr=ui.getUserByEmail(email);
		
		String a1=usr.getAnswer1().trim();
		String a2=usr.getAnswer2().trim();
		String d=usr.getDob();
		
		if(answer1.equalsIgnoreCase(a1) && answer2.equalsIgnoreCase(a2) && dob.equalsIgnoreCase(d)){
			ModelAndView m=new ModelAndView("new-password");
			m.addObject("recover",email);
			return m;
		}
		else {
			ModelAndView m=new ModelAndView("redirect:/accountRecovery");
			m.addObject("msg","Your answers are incorrect");
			return m;
		}
	}
	
	@RequestMapping(value="/passwordReset")
	public ModelAndView newPassword(HttpServletRequest request,User user){
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String confirm=request.getParameter("confirm");
		user=ui.getUserByEmail(email);
		user.setPwd(password);
		user.setConf(confirm);
		boolean res=ui.update(user);
		if(res==true){
			ModelAndView m=new ModelAndView("redirect:/");
			return m;
		}
		else{
			ModelAndView m=new ModelAndView("redirect:/createPassword");
			return m;
		}
	}
	
	
	@RequestMapping(value="/performRegistration")
	public ModelAndView performRegistration(@ModelAttribute("user") User user,Map<String,Object> model){
		
		
		if(ui.insert(user)){
			ModelAndView m=new ModelAndView("personal-details");
			List<String> q1= new ArrayList<String>();
			    q1.add("What was your childhood nickname?");
			    q1.add("What is the name of your favorite childhood friend?");
			    q1.add("What is the middle name of your oldest child?");
			    q1.add("In what city or town did your mother and father meet?");
			    q1.add("What is your favorite movie?");
			    q1.add("What is your pet’s name?");
			    q1.add("In what town was your first job?");
			    q1.add("What was your favorite food as a child?");
			List<String> q2= new ArrayList<String>();
				q2.add("What was your favorite food as a child?");
				q2.add("What was your childhood nickname?");
			    q2.add("What is the name of your favorite childhood friend?");
			    q2.add("What is the middle name of your oldest child?");
			    q2.add("In what city or town did your mother and father meet?");
			    q2.add("What is your favorite movie?");
			    q2.add("What is your pet’s name?");
			    q2.add("In what town was your first job?");
			List<String> g= new ArrayList<String>();
			    g.add("male");
			    g.add("female");
			    model.put("gender",g);
				model.put("question1",q1);
				model.put("question2",q2);
				return m;
			}
			else{
				ModelAndView m=new ModelAndView("redirect:/");
				return m;
			}
		
	}
	
	@RequestMapping(value="/completeRegistration")
	public ModelAndView completeRegistration(User user){
		String email=user.getEmail();
		User u=ui.getUserByEmail(email);
		user.setId(u.getId());
		user.setPwd(u.getPwd());
		user.setConf(u.getConf());
		user.setDate(dt.date());
		user.setTime(dt.time());
		ui.update(user);
		ModelAndView m=new ModelAndView("redirect:/");
		return m;
	}
	
	@RequestMapping("/edit-profile/{email:.+}")
	public ModelAndView editProfile(@PathVariable("email")String email,@ModelAttribute("getUser")User user){
		user=ui.getUserByEmail(email);
		ModelAndView m=new ModelAndView("edit-profile");
		if(user.getGender().equals("male")){
			m.addObject("profile","avtar-boy");
		}
		else if(user.getGender().equals("female")){
			m.addObject("profile","avtar-girl");
		}
		m.addObject("edit",user);
		return m;
	}
	
	@RequestMapping(value="/updateProfile",method=RequestMethod.POST)
	public ModelAndView updateProfile(User user){
		ui.update(user);
		ModelAndView m=new ModelAndView("redirect:/edit-profile");
		return m;
	}
}
