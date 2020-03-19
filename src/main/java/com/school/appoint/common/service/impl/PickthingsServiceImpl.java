package com.school.appoint.common.service.impl;

import com.school.appoint.common.dao.PickthingsDao;
import com.school.appoint.common.domain.PickthingsDO;
import com.school.appoint.common.service.PickthingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PickthingsServiceImpl implements PickthingsService {
	@Autowired
	private PickthingsDao pickthingsDao;
	
	@Override
	public PickthingsDO get(Long id){
		return pickthingsDao.get(id);
	}
	
	@Override
	public List<PickthingsDO> list(Map<String, Object> map){
		return pickthingsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return pickthingsDao.count(map);
	}
	
	@Override
	public int save(PickthingsDO pickthings){
		return pickthingsDao.save(pickthings);
	}
	
	@Override
	public int update(PickthingsDO pickthings){
		return pickthingsDao.update(pickthings);
	}
	
	@Override
	public int remove(Long id){
		return pickthingsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return pickthingsDao.batchRemove(ids);
	}
	
}
