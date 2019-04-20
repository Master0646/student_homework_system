package com.tujietg.gradpro.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tujietg.gradpro.mapper.HistoryMapper;
import com.tujietg.gradpro.pojo.History;
import com.tujietg.gradpro.service.TeacherScoringService;

/**
 * 
 * Created by tujietg on Apr 20, 2019
 */
@Service
public class TeacherScoringServiceImpl implements TeacherScoringService {

	@Autowired
	HistoryMapper historyMapper;

	@Override
	public String teacherScoring(String hid, Integer fraction) {
		if (StringUtils.isEmpty(hid) || StringUtils.isEmpty(fraction)) {
			return "false";
		}
		History history = historyMapper.getEntityByHID(hid);
		if (StringUtils.isEmpty(history)) {
			return "false";
		}
		history.setFraction(fraction);
		historyMapper.upHistoryDataByHid(history);
		return "true";
	}

}
