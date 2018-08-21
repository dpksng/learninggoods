package com.learninggoods.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.learninggoods.dao.entity.Admin;
import com.learninggoods.dao.entity.Course;
import com.learninggoods.dao.entity.Feedbacks;
import com.learninggoods.dao.entity.Notifications;
import com.learninggoods.dao.entity.Posts;
import com.learninggoods.dao.entity.Roles;
import com.learninggoods.dao.entity.Tests;
import com.learninggoods.dao.entity.User;
import com.learninggoods.dao.impl.AdminDaoImpl;
import com.learninggoods.dao.impl.CourseDaoImpl;
import com.learninggoods.dao.impl.FeedbacksDaoImpl;
import com.learninggoods.dao.impl.NotificationsDaoImpl;
import com.learninggoods.dao.impl.PostsDaoImpl;
import com.learninggoods.dao.impl.RolesDaoImpl;
import com.learninggoods.dao.impl.TestsDaoImpl;
import com.learninggoods.dao.impl.UserDaoImpl;
import com.learninggoods.services.DateTime;


@Controller
@SessionAttributes(value = {"ad","profile","crs"})
public class AdminController {
	
		@Autowired
		private AdminDaoImpl ai;
		
		@Autowired
		private FeedbacksDaoImpl fi;
		
		@Autowired
		private UserDaoImpl ui;
		
		@Autowired
		private RolesDaoImpl ri;

		@Autowired
		private PostsDaoImpl pi;
	
		@Autowired
		private TestsDaoImpl ti;
		
		@Autowired
		private CourseDaoImpl ci;
		
		@Autowired
		private DateTime dt;
		
		@Autowired
		private NotificationsDaoImpl ni;
	
		@RequestMapping(value="/admin-login")
		public String getAdminLogin(){
			return "admin-login";
		}
		
		@RequestMapping(value=("/admin"),method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView getAdminDashboard(Principal principal,Admin admin){
			ModelAndView m=new ModelAndView("admin");
			admin=ai.getAdminById(principal.getName());
			if(admin.getGender().equals("female")){
				m.addObject("profile","profile-female");
			
			}
			else if(admin.getGender().equals("male")){
				m.addObject("profile","profile-male");
				
			}
			else{
				m.addObject("profile","profile");
			}
			
			m.addObject("ad",admin.getName());
			return m;
		}
		
				
		@RequestMapping("/admin/manage-feedbacks")
		public ModelAndView getManageFeedbacks(Map<String, Object> model){
			List<Feedbacks> list=fi.getAllFeedbacks();
			model.put("list",list);
			ModelAndView m=new ModelAndView("manage-feedbacks");
			return m;
		}
		
		@RequestMapping(value=("/admin/deleteFeedback/{id}"),method=RequestMethod.GET)  
		public ModelAndView deleteFeedback(@PathVariable("id") long id){
		    fi.delete(id);
		    return new ModelAndView("redirect:/admin/manage-feedbacks");  
		 }
		
		
		@RequestMapping("/admin/manage-users")
		public ModelAndView getManageUsers(@ModelAttribute("user")User user,Map<String, Object> model){
			List<User> list=ui.getAllUser();
			model.put("list",list);
			ModelAndView m=new ModelAndView("manage-users");
			return m;
		}
		
		@RequestMapping(value=("/admin/updateUser"),method=RequestMethod.POST)  
	    public ModelAndView updateUser(User user){
	        ui.update(user); 
	        return new ModelAndView("redirect:/admin/manage-users");  
	    }
		
		@RequestMapping(value=("/admin/deleteUser/{email:.+}"),method=RequestMethod.GET)  
		public ModelAndView deleteUser(@PathVariable("email")String email){
		    ui.delete(email);
		    return new ModelAndView("redirect:/admin/manage-users");
		}
		
		@RequestMapping("/logout")
		public ModelAndView getLogout(){
			ModelAndView m=new ModelAndView("/admin");
			return m;
		}
		
		@RequestMapping("/logFail")
		public ModelAndView getLogFail(){
			ModelAndView m=new ModelAndView("/admin");
			return m;
		}
	
		@RequestMapping(value="/admin/add",method=RequestMethod.GET)
		public ModelAndView addAdmin(@ModelAttribute("admin")Admin admin){
			ModelAndView m=new ModelAndView("admin-registration");
			return m;
		}
		
		@RequestMapping(value="/admin/registerAdmin")
		public ModelAndView registerAdmin(Admin admin){
			boolean res=ai.insert(admin);
			Roles role=new Roles();
			role.setEmail(admin.getId());
			role.setRole("ROLE_ADMIN");
			if(res==true){
				ri.insert(role);
			}
			ModelAndView m=new ModelAndView("redirect:/admin/add");
			return m;
		}
		
		@RequestMapping("/admin/manage-posts")
		public ModelAndView getManagePosts(Map<String, Object> model){
			List<Posts> list=pi.getAllPosts();
			model.put("list",list);
			ModelAndView m=new ModelAndView("manage-posts");
			return m;
		}
		
		@RequestMapping(value=("/admin/deletePost/{number}"),method=RequestMethod.GET)  
		public ModelAndView deletePost(@PathVariable("number") long number){
		    pi.delete(number);
		    return new ModelAndView("redirect:/admin/manage-posts");  
		 }
		
		@RequestMapping("/admin/manage-tests")
		public ModelAndView getManageTests(@ModelAttribute("test")Tests test,Map<String, Object> model){
			List<Tests> list=ti.getAllTests();
			List<String> q1= new ArrayList<String>();
		    q1.add("Java");
		    q1.add("Python");
		    q1.add("JavaScript");
		    q1.add("HTML");
		    q1.add("CSS");
			model.put("list",list);
			model.put("s1",q1);
			ModelAndView m=new ModelAndView("manage-tests");
			return m;
		}
		
		@RequestMapping(value="/admin/addTest",method=RequestMethod.POST)
		public ModelAndView addTest(Tests test){
			ti.insert(test);
			ModelAndView m=new ModelAndView("redirect:/admin/manage-tests");
			return m;
		}
		
		@RequestMapping(value=("/admin/updateTest"),method=RequestMethod.POST)  
	    public ModelAndView updateTest(Tests test){
	        ti.update(test); 
	        return new ModelAndView("redirect:/admin/manage-tests");  
	    }
		
		@RequestMapping(value=("/admin/deleteTest/{number}"),method=RequestMethod.GET)  
		public ModelAndView deleteTest(@PathVariable("number") long number){
		    ti.delete(number);
		    return new ModelAndView("redirect:/admin/manage-tests");
		}
		
		@RequestMapping("/admin/manage-courses")
		public ModelAndView getManageCourses(@ModelAttribute("course")Course course,Map<String, Object> model){
			List<Course> list=ci.getAllCourse();
			model.put("list",list);
			ModelAndView m=new ModelAndView("manage-courses");
			return m;
		}
		
		@RequestMapping(value="/admin/addCourse",method=RequestMethod.POST)
		public ModelAndView addCourse(Course course){
			ci.insert(course);
			ModelAndView m=new ModelAndView("redirect:/admin/manage-courses");
			return m;
		}
		
		@RequestMapping(value=("/admin/updateCourse"),method=RequestMethod.POST)  
	    public ModelAndView updateCourse(Course course){
	        ci.update(course); 
	        return new ModelAndView("redirect:/admin/manage-courses");  
	    }
		
		@RequestMapping(value=("/admin/deleteCourse/{id}"),method=RequestMethod.GET)  
		public ModelAndView deleteCourse(@PathVariable("id") long id){
		    ci.delete(id);
		    return new ModelAndView("redirect:/admin/manage-courses");
		}
			
		@RequestMapping("/admin/manage-notifications")
		public ModelAndView getManageNotifications(@ModelAttribute("note")Notifications note,Map<String, Object> model){
			List<Notifications> list=ni.getAllNotifications();
			model.put("list",list);
			ModelAndView m=new ModelAndView("manage-notifications");
			return m;
		}
		
		@RequestMapping(value="/admin/addNotification",method=RequestMethod.POST)
		public ModelAndView addNotification(Notifications note){
			note.setDate(dt.date());
			note.setTime(dt.time());
			note.setUrl("urgent");
			ni.insert(note);
			ModelAndView m=new ModelAndView("redirect:/admin/manage-notifications");
			return m;
		}
		
		@RequestMapping(value=("/admin/deleteNotification/{id}"),method=RequestMethod.GET)  
		public ModelAndView deleteNotification(@PathVariable("id") long id){
		    ni.delete(id);
		    return new ModelAndView("redirect:/admin/manage-notifications");
		}
		
}
