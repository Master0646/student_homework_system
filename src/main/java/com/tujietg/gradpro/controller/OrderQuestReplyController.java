package com.tujietg.gradpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tujietg.gradpro.exception.FileException;
import com.tujietg.gradpro.pojo.OrderQuestionsReply;
import com.tujietg.gradpro.pojo.User;
import com.tujietg.gradpro.service.OrderQuestReplyService;

/**
 * 评论的增加获取
 * 
 * Created by tujietg on Apr 17, 2019
 */
@Controller
public class OrderQuestReplyController {

	@Autowired
	OrderQuestReplyService orderQuestReplyService;

	@RequestMapping("/questAndReply")
	public String questAndReply(String hid, Model model, HttpServletRequest request) throws Exception {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		if (hid == null || "".equals(hid)) {
			throw new FileException("参数为空！");
		}
		List<OrderQuestionsReply> list = orderQuestReplyService.readOrderQuestReply(hid);
		model.addAttribute("user", user);
		model.addAttribute("hid", hid);
		model.addAttribute("OrderQuestionsReplyList", list);
		return "jsp/questAndReply.jsp";
	}

	@RequestMapping("/questAndReplyTeacher")
	public String questAndReplyTeacher(String hid, Model model, HttpServletRequest request) throws Exception {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		if (hid == null || "".equals(hid)) {
			throw new FileException("参数为空！");
		}
		List<OrderQuestionsReply> list = orderQuestReplyService.readOrderQuestReply(hid);
		model.addAttribute("user", user);
		model.addAttribute("hid", hid);
		model.addAttribute("OrderQuestionsReplyList", list);
		return "jsp/questAndReplyTeacher.jsp";
	}

	// 增加
	@RequestMapping("/addStudentQuestion")
	@ResponseBody
	public String addOrderQuestAndReply(HttpServletRequest request) {
		String text = request.getParameter("text");
		String hid = request.getParameter("hid");
		return orderQuestReplyService.addOrderQuestReply(text, hid);
	}

	// 增加
	@RequestMapping("/addTeacherReply")
	@ResponseBody
	public String addTeacherReply(HttpServletRequest request) {
		String text = request.getParameter("text");
		// 问题所对应的id
		String id = request.getParameter("id");
		return orderQuestReplyService.addTeacherReply(text, Integer.valueOf(id));
	}

	// 删除
	@RequestMapping("/deleteOrderQuestReply")
	@RequiresPermissions("admin")
	public void deleteOrderQuestReply(Integer id) {
		orderQuestReplyService.deleteOrderQuestReply(id);
	}

	// read
	@RequestMapping("/readOrderQuestReply")
	public List<OrderQuestionsReply> readOrderQuestReply(Integer mark, String oid) {
		return orderQuestReplyService.readOrderQuestReply(oid);
	}

}
