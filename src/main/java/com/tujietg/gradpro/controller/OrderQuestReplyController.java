package com.tujietg.gradpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
			throw new FileException("下载失败：参数为空！");
		}
		List<OrderQuestionsReply> list = orderQuestReplyService.readOrderQuestReply(hid);
		model.addAttribute("user", user);
		model.addAttribute("OrderQuestionsReplyList", list);
		return "jsp/questAndReply.jsp";
	}

	// 增加
	@RequestMapping("/addOrderQuestAndReply")
	public boolean addOrderQuestAndReply(OrderQuestionsReply orderQuestionsReply) {
		return orderQuestReplyService.addOrderQuestReply(orderQuestionsReply);
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
