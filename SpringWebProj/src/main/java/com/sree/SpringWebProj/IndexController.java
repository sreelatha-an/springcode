package com.sree.SpringWebProj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String indexCall() {
		System.out.println("indise indexcall()...");
		//return "index.jsp";
		return "index";
	}
	
	@RequestMapping("add")  //modelandView
	public ModelAndView  add(@RequestParam("num1") int n1, int num2, ModelAndView modelNView)
	//add(HttpServletRequest req,HttpSession session) can also use this..
	{
		int rs = n1 + num2+10;		
		modelNView.addObject("result",rs);
		modelNView.setViewName("result"); // here it means result.jsp
		return modelNView;
	}
	
/*	@RequestMapping("add")  //use model to set object 
	public String  add(@RequestParam("num1") int n1, int num2, Model model)
	//add(HttpServletRequest req,HttpSession session) can also use this..
	{
//		int num1 = Integer.parseInt(req.getParameter("num1"));
//		int num2 = Integer.parseInt(req.getParameter("num2"));		
		int result = n1 + num2+100;		
		//session.setAttribute("result",result);
		model.addAttribute("result",result);		
		return "result";
	}  
	*/
}
