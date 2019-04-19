package com.tujietg.gradpro.service;

import java.util.List;

import com.tujietg.gradpro.pojo.OrderQuestionsReply;

/**
 * 
 * Created by tujietg on Apr 2019
 */
public interface OrderQuestReplyService {
	// 增加学生提问
	public String addOrderQuestReply(String text, String hid);

	// 增加老师回答
	public String addTeacherReply(String text, Integer id);

	// 删除
	public void deleteOrderQuestReply(Integer id);

	// read
	public List<OrderQuestionsReply> readOrderQuestReply(String hid);
}
