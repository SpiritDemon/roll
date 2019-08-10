package com.spiritdemon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.spiritdemon.pojo.Roll;

public interface RollMapper {
	/**
	 * 根据用户名称查询roll点信息
	 * @param username
	 * @return
	 */
	@Select("select * from roll1 where username=#{arg0}")
	Roll selRollByUsername(String username);
	/**
	 * 根据用户名称及roll到的点数添加roll点信息
	 * @param username
	 * @param rollValue
	 * @return
	 */
	@Insert("insert into roll1 values(default,#{arg0},#{arg1},now())")
	int insRollByUsernameAndRollValue(String username, int rollValue);
	/**
	 * 查询全部roll点信息
	 * @return
	 */
	@Select("select * from roll1")
	List<Roll> selAll();
}
