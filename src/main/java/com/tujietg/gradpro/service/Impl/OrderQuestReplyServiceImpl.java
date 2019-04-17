package com.tujietg.gradpro.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tujietg.gradpro.mapper.OrderQuestionsReplyMapper;
import com.tujietg.gradpro.pojo.OrderQuestionsReply;
import com.tujietg.gradpro.pojo.OrderQuestionsReplyExample;
import com.tujietg.gradpro.service.OrderQuestReplyService;

/**
 * 评论模块
 * 
 * Created by tujietg on Apr 2019
 */
@Service
public class OrderQuestReplyServiceImpl implements OrderQuestReplyService {

	@Autowired
	OrderQuestionsReplyMapper orderQuestionsReplyMapper;

	// 增加
	@Override
	public boolean addOrderQuestReply(OrderQuestionsReply orderQuestionsReply) {
		if (StringUtils.isEmpty(orderQuestionsReply)) {
			return false;
		}
		orderQuestionsReplyMapper.insert(orderQuestionsReply);
		return false;
	}

	// 删除
	@Override
	public void deleteOrderQuestReply(Integer id) {
		int a = orderQuestionsReplyMapper.deleteByPrimaryKey(id);
	}

	// 读取
	@Override
	public List<OrderQuestionsReply> readOrderQuestReply(String hid) {
		orderQuestionsReplyMapper.selectByPrimaryKey(10);
		return null;
	}

}
