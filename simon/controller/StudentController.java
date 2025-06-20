package com.simon.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simon.entity.Student;
import com.simon.service.StuService;
import com.simon.service.StudentServiceImpl;

@Controller
public class StudentController {

	
	private StuService sts;
	private StudentServiceImpl ssi;
	public StudentController(StudentServiceImpl sts) {
		this.sts=sts;
		this.ssi=sts;
	}
	
	
	
	
	
	
	@GetMapping("/")
	 public ModelAndView myIndex()
	{
		ModelAndView mdv = new ModelAndView();
		mdv.setViewName("index");
		return mdv;
	}
	
	
	@PostMapping("/savestudent")
	public ModelAndView submitStudent(Student s)
	{
		ModelAndView mav=new ModelAndView();
		boolean isSaved = sts.saveStudent(s);
		if(isSaved)
		{
			mav.addObject("smsg", "Student data Saved successfully");
						
		}
		
		else {
			 mav.addObject("emsg", "data saving was unsucessfull");
		}
		
		mav.setViewName("index");
		return mav;
		
	}
	
	
	@GetMapping("/getData")
	public ModelAndView getStudents()
	{
		List<Student> allStu = sts.getAllStudents();
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("students", allStu);
		mav.setViewName("data");
		return mav;
		
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteMyStudent(@RequestParam("sid") Integer sid)
	{
		sts.delete(sid);
		List<Student> allStu = sts.getAllStudents();
		ModelAndView mdv = new ModelAndView();
		mdv.addObject("students", allStu);
		mdv.addObject("smsg", "Student got deleted succesfully");
		mdv.setViewName("data");
		return mdv;
	}
	
	@GetMapping("/sendmail")
	public ModelAndView sendTheMail(@RequestParam("email") String email,Student s) {
		
		boolean senMail = ssi.sendMail(email,s);
		ModelAndView mdv = new ModelAndView();
		if(senMail) {
			mdv.addObject("smesg", "emailsentsuccessfully");
		}
		else {
			mdv.addObject("smesg", "email was not sent");
		}
		
		List<Student> allStu = sts.getAllStudents();
		mdv.addObject("students", allStu);
		mdv.setViewName("data");
		return mdv;
		
	}
	
	@GetMapping("mindex")
	public String mindex(Model model) {
		String msg="Hi I am Chitti memory one terabyte speed one tera byte";
		model.addAttribute("mmsg", msg);
		return "index";
		
		
	}
	
	
	
}