package com.tujietg.gradpro.service.Impl;

import java.util.Date;
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

	// 增加学生提问
	@Override
	public String addOrderQuestReply(String text, String hid) {
		if (StringUtils.isEmpty(text) || StringUtils.isEmpty(hid)) {
			return "false";
		}
		OrderQuestionsReply orderQuestionsReply = new OrderQuestionsReply();
		orderQuestionsReply.setHistoryId(hid);
		orderQuestionsReply.setStatusQuestions(text);
		orderQuestionsReply.setQuestTime(new Date());
		int total = orderQuestionsReplyMapper.insert(orderQuestionsReply);
		if (total == 1) {
			return "true";
		} else {
			return "false";
		}
	}

	// 删除
	@Override
	public void deleteOrderQuestReply(Integer id) {
		int a = orderQuestionsReplyMapper.deleteByPrimaryKey(id);
	}

	// 读取
	@Override
	public List<OrderQuestionsReply> readOrderQuestReply(String hid) {
		if (StringUtils.isEmpty(hid)) {
			return null;
		}
		OrderQuestionsReplyExample example = new OrderQuestionsReplyExample();
		example.createCriteria().andHistoryIdEqualTo(hid);
		return orderQuestionsReplyMapper.selectByExample(example);
	}

	// 增加老师回答
	@Override
	public String addTeacherReply(String text, Integer id) {
		if (StringUtils.isEmpty(text) || StringUtils.isEmpty(id)) {
			return "false";
		}
		OrderQuestionsReply orderQuestionsReply = orderQuestionsReplyMapper.selectByPrimaryKey(id);
		orderQuestionsReply.setTeacherReply(text);
		orderQuestionsReplyMapper.updateByPrimaryKey(orderQuestionsReply);
		return "true";
	}

}
