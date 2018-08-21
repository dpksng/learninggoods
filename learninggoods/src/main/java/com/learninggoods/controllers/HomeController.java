package com.learninggoods.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.learninggoods.dao.entity.Feedbacks;
import com.learninggoods.dao.entity.Notifications;
import com.learninggoods.dao.entity.Posts;
import com.learninggoods.dao.entity.User;
import com.learninggoods.dao.impl.FeedbacksDaoImpl;
import com.learninggoods.dao.impl.NotificationsDaoImpl;
import com.learninggoods.dao.impl.PostsDaoImpl;
import com.learninggoods.dao.impl.ReplyDaoImpl;
import com.learninggoods.services.DateTime;

@Controller
@SessionAttributes(value = {"sn"})
public class HomeController {
	
	@Autowired
	DateTime dt;
	
	@Autowired
	FeedbacksDaoImpl fi;

	@Autowired
	ReplyDaoImpl ri;
	
	@Autowired
	PostsDaoImpl pi;
	
	@Autowired
	NotificationsDaoImpl ni;
	
	
	
	@RequestMapping(value={"/","/index"})
	public ModelAndView getHomePage(@ModelAttribute("user")User user){	
		ModelAndView m=new ModelAndView("index");
		return m;
	}
	
	@RequestMapping(value={"/default"})
	public ModelAndView getDefault(Map<String, Object> model){
		List<Posts> list=pi.getAllPosts();
		List<Notifications> list1=ni.getAllNotifications();
		model.put("sn", list1);
		model.put("list",list);
		ModelAndView m=new ModelAndView("default");
		return m;
	}
	
	@RequestMapping(value={"/java"})
	public ModelAndView getJava(){
		ModelAndView m=new ModelAndView("java");
		return m;
	}
	
	@RequestMapping(value={"/html"})
	public ModelAndView getHtml(){
		ModelAndView m=new ModelAndView("html");
		return m;
	}
	
	@RequestMapping(value={"/css"})
	public ModelAndView getCss(){
		ModelAndView m=new ModelAndView("css");
		return m;
	}
	
	@RequestMapping(value={"/python"})
	public ModelAndView getPython(){
		ModelAndView m=new ModelAndView("python");
		return m;
	}
	
	@RequestMapping(value={"/javascript"})
	public ModelAndView getJavaScript(){
		ModelAndView m=new ModelAndView("javascript");
		return m;
	}
	
	@RequestMapping(value={"/post"})
	public ModelAndView getPost(Map<String, Object> model){
		List<Posts> list=pi.getAllPosts();
		model.put("list",list);
		ModelAndView m=new ModelAndView("post");
		return m;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView getAboutPage(){
		ModelAndView m=new ModelAndView("about");
		return m;
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ModelAndView getContactPage(@ModelAttribute("feed")Feedbacks feed){
		ModelAndView m=new ModelAndView("contact");
		return m;
	}
	
	@RequestMapping(value="/sendContact",method=RequestMethod.POST)
	public ModelAndView sendContact(Feedbacks feed){
		feed.setDate(dt.date());
		feed.setTime(dt.time());
		fi.insert(feed);
		ModelAndView m=new ModelAndView("redirect:/contact");
		m.addObject("msg","Message Sent");
		return m;
	}
	
	@RequestMapping(value="/feedback",method=RequestMethod.GET)
	public ModelAndView getFeedbackPage(@ModelAttribute("feed")Feedbacks feed){
		ModelAndView m=new ModelAndView("feedback");
		return m;
	}
	
	@RequestMapping(value="/sendFeedback",method=RequestMethod.POST)
	public ModelAndView sendFeedback(Feedbacks feed){
		feed.setDate(dt.date());
		feed.setTime(dt.time());
		fi.insert(feed);
		ModelAndView m=new ModelAndView("redirect:/feedback");
		m.addObject("msg","Feedback Sent");
		return m;
	}
	
	@RequestMapping(value="/terms")
	public ModelAndView getTermsPage(){
		ModelAndView m=new ModelAndView("terms");
		return m;
	}
	
	@RequestMapping(value="/privacy-policy")
	public ModelAndView getPolicyPage(){
		ModelAndView m=new ModelAndView("privacy-policy");
		return m;
	}

	@RequestMapping(value="/disclaimer")
	public ModelAndView disclaimer(){
		ModelAndView m=new ModelAndView("disclaimer");
		return m;
	}

}
