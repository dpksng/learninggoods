package com.learninggoods.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.learninggoods.dao.entity.Posts;
import com.learninggoods.dao.entity.Reply;
import com.learninggoods.dao.entity.Tests;
import com.learninggoods.dao.impl.PostsDaoImpl;
import com.learninggoods.dao.impl.ReplyDaoImpl;
import com.learninggoods.dao.impl.TestsDaoImpl;

@Controller
@SessionAttributes(value = {"ans"})
public class ModulesController {
	
	@Autowired
	PostsDaoImpl pi;
	
	@Autowired
	ReplyDaoImpl ri;
	
	@Autowired
	TestsDaoImpl ti;
	
	@RequestMapping("/postQuery/{email:.+}")
    public ModelAndView postQuery(@PathVariable("email")String email,Posts post,HttpServletRequest request){
				
		String title=request.getParameter("title");
		String query=request.getParameter("query");
		
		post.setTitle(title);
		post.setDesc(query);
		post.setPuser(email);
		
		pi.insert(post);
	
		ModelAndView m=new ModelAndView("redirect:/default");
		return m;
    }

	@RequestMapping("/reply/{email:.+}/{number}")
    public ModelAndView reply(@PathVariable("email")String email,@PathVariable("number")Long number,Reply reply,HttpServletRequest request){
				
		String answer=request.getParameter("answer");
		
		reply.setId(number);
		reply.setReply(answer);
		reply.setRuser(email);
		
		Posts post=pi.getPostById(number);
		reply.setPuser(post.getPuser());
		ri.insert(reply);
		
		ModelAndView m=new ModelAndView("redirect:/default");
		return m;
    }
	
	@RequestMapping("/answers/{number}")
    public ModelAndView answers(@PathVariable("number")Long number,Reply reply,Map<String, Object> model){
		ModelAndView m=new ModelAndView("answers");
		List<Reply> list=ri.getAllReplyByPost(number);
		Posts post=pi.getPostById(number);
		model.put("list",list);
		m.addObject("posted",post);
		return m;
    }
	
	@RequestMapping(value={"/test/{test}"})
	public ModelAndView getTest(@PathVariable("test")String test,Map<String,Object> model){
		List<Tests> list=ti.getAllTestsBytest(test);
		
		Collections.shuffle(list);
	    int randomSeriesLength=5;
	 
	    List<Tests> random=list.subList(0, randomSeriesLength);
	    List<String> ans=new ArrayList<String>();
	    for (Tests l:random) {
			ans.add(l.getAnswer());
		}
	    model.put("ans",ans);
		model.put("list",random);
		ModelAndView m=new ModelAndView("test");
		m.addObject("lang",test);
		return m;
	}
	
	
	@RequestMapping(value="/submitTest/{ans}")
	public ModelAndView submitTest(@PathVariable("ans")String[] ans,HttpServletRequest request){
		
		String answer1=request.getParameter("question1");
		String answer2=request.getParameter("question2");
		String answer3=request.getParameter("question3");
		String answer4=request.getParameter("question4");
		String answer5=request.getParameter("question5");
			
		String ans1=ans[0];
		String ans2=ans[1];
		String ans3=ans[2];
		String ans4=ans[3];
		String ans5=ans[4];
		
		int score=0;
		
		System.out.println(answer1+" = "+ans1+" = "+score);
		if(answer1.equalsIgnoreCase(ans1)){
			score=score+1;
		}
		System.out.println(ans2+" = "+answer2+" = "+score);
		if(answer2.equalsIgnoreCase(ans2)){
			score=score+1;	
		}
		System.out.println(ans3+" = "+answer3+" = "+score);
		if(answer3.equalsIgnoreCase(ans3)){
			score=score+1;
		}
		System.out.println(ans4+" = "+answer4+" = "+score);
		if(answer4.equalsIgnoreCase(ans4)){
			score=score+1;
		}
		System.out.println(ans5+" = "+answer5+" = "+score);
		if(answer5.equalsIgnoreCase(ans5)){
			score=score+1;
		}
		
		ModelAndView m=new ModelAndView("test-result");
		m.addObject("score",score);
		if(score>=3){
			m.addObject("result","Congratulations, You Passed this skill test");
		}
		else{
			m.addObject("result","Sorry to say but you are failed");
		}
		
		return m;
	}
	
}
