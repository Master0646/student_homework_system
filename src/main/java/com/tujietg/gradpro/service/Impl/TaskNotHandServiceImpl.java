package com.tujietg.gradpro.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tujietg.gradpro.mapper.HistoryMapper;
import com.tujietg.gradpro.mapper.OrderInfoMapper;
import com.tujietg.gradpro.pojo.History;
import com.tujietg.gradpro.pojo.OrderInfo;
import com.tujietg.gradpro.service.TaskNotHandService;

/**
 * 
 * Created by tujietg on Apr 2019
 */
@Service
public class TaskNotHandServiceImpl implements TaskNotHandService {

	@Autowired
	OrderInfoMapper orderInfoMapper;

	@Autowired
	HistoryMapper HistoryMapper;

	@Override
	public List<String> studentNotHand(String uid) {
		// 得到全部作业的oid
		List<OrderInfo> orderList = orderInfoMapper.getOrderInfoEntity();
		// 得到uid的history
		List<History> hisList = HistoryMapper.getUpListByUID(uid);
		List<Integer> list = new ArrayList<Integer>();
		List<String> resultList = new ArrayList<String>();
		for (OrderInfo order : orderList) {
			list.add(order.getOid());
		}
		for (History his : hisList) {
			list.remove(his.getHoid());
		}
		for (Integer oid : list) {
			resultList.add(orderInfoMapper.getOrderInfoEntityByOID(oid).getOsubject());
		}
		return resultList;
	}

}
