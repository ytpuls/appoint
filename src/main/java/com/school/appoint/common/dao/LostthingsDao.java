package com.school.appoint.common.dao;

import com.school.appoint.common.domain.LostthingsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author yangtao
 * @email 541502337@qq.com
 * @date 2019-03-13 15:39:02
 */
@Mapper
public interface LostthingsDao {

	LostthingsDO get(Long id);
	
	List<LostthingsDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(LostthingsDO lostthings);
	
	int update(LostthingsDO lostthings);
	
	int remove(Long ID);
	
	int batchRemove(Long[] ids);
}
