package com.spiritdemon.service;

import java.util.List;

import com.spiritdemon.pojo.Roll;

public interface RollService {
	Roll showRoll(String username);
	
	int insRoll(String username, int rollValue);
	
	List<Roll> showAll();
}
