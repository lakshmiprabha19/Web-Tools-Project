package com.neu.myapplication.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.neu.myapplication.view.PdfReportView;

@Controller
public class PdfReportController {
	@RequestMapping(value = "/viewReport")
	public ModelAndView createReport()
	{
		View view = new PdfReportView();		
		return new ModelAndView(view);
	}

}
