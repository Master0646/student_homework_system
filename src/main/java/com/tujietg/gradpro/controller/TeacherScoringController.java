package com.tujietg.gradpro.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tujietg.gradpro.service.TeacherScoringService;

/**
 * 
 * Created by tujietg on Apr 2019
 */
@Controller
public class TeacherScoringController {

	@Autowired
	TeacherScoringService teacherScoringService;

	@RequestMapping("/addTeacherScoring")
	@ResponseBody
	public String teacherScoring(HttpServletRequest request) {
		String fraction = request.getParameter("fraction");
		String hid = request.getParameter("hid");
		return teacherScoringService.teacherScoring(hid, Integer.valueOf(fraction));
	}

}
