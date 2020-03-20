package com.school.appoint.common.dao;

import com.school.appoint.common.domain.AppointDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangtao
 * @email 541502337@qq.com
 * @date 2020-03-20 16:42:48
 */
@Mapper
public interface AppointDao {

	AppointDO get(Integer id);
	
	List<AppointDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AppointDO appoint);
	
	int update(AppointDO appoint);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
