package com.yewei.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/my", method = {RequestMethod.GET, RequestMethod.POST})  
public class MyController {
    
    @RequestMapping("/views")
    public ModelAndView view(HttpServletRequest request){
        String path = request.getParameter("path") + "";
        ModelAndView mav = new ModelAndView();
        mav.setViewName(path);
        
        String contextPath = request.getContextPath();
        mav.addObject("contextPath",contextPath);
        
        return mav;
    }
    
    @RequestMapping(value = "/index")  
    public String index() {  
        return "index";  
    }
    
    
    @RequestMapping(value = "/bg")  
    public ModelAndView bg(HttpServletRequest request) {  
    	String path = request.getParameter("path") + "";
        ModelAndView mav = new ModelAndView();
        mav.setViewName(path);
        
        String contextPath = request.getContextPath();
        mav.addObject("contextPath",contextPath);
        
        return mav;
    }
}
