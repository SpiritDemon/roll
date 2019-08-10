package com.spiritdemon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spiritdemon.mapper.RollMapper;
import com.spiritdemon.pojo.Roll;
import com.spiritdemon.service.RollService;

@Service
public class RollServiceImpl implements RollService {
	@Resource
	private RollMapper rollMapper;
	
	@Override
	public Roll showRoll(String username) {
		return rollMapper.selRollByUsername(username);
	}

	@Override
	public int insRoll(String username, int rollValue) {
		return rollMapper.insRollByUsernameAndRollValue(username, rollValue);
	}

	@Override
	public List<Roll> showAll() {
		return rollMapper.selAll();
	}
}
