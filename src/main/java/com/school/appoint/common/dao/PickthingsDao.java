package com.school.appoint.common.dao;

import com.school.appoint.common.domain.PickthingsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author yangtao
 * @email 541502337@qq.com
 * @date 2019-03-13 15:39:11
 */
@Mapper
public interface PickthingsDao {

	PickthingsDO get(Long id);
	
	List<PickthingsDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(PickthingsDO pickthings);
	
	int update(PickthingsDO pickthings);
	
	int remove(Long ID);
	
	int batchRemove(Long[] ids);
}
