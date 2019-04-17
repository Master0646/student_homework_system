package com.tujietg.gradpro.service;

import java.util.List;

import com.tujietg.gradpro.pojo.OrderQuestionsReply;

/**
 * 
 * Created by tujietg on Apr 2019
 */
public interface OrderQuestReplyService {
	// 增加
	public boolean addOrderQuestReply(OrderQuestionsReply orderQuestionsReply);

	// 删除
	public void deleteOrderQuestReply(Integer id);

	// read
	public List<OrderQuestionsReply> readOrderQuestReply(String hid);
}
