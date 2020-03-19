package com.school.appoint.common.service.impl;

import com.school.appoint.common.dao.LostthingsDao;
import com.school.appoint.common.domain.LostthingsDO;
import com.school.appoint.common.service.LostthingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class LostthingsServiceImpl implements LostthingsService {
	@Autowired
	private LostthingsDao lostthingsDao;
	
	@Override
	public LostthingsDO get(Long id){
		return lostthingsDao.get(id);
	}
	
	@Override
	public List<LostthingsDO> list(Map<String, Object> map){
		return lostthingsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return lostthingsDao.count(map);
	}
	
	@Override
	public int save(LostthingsDO lostthings){
		return lostthingsDao.save(lostthings);
	}
	
	@Override
	public int update(LostthingsDO lostthings){
		return lostthingsDao.update(lostthings);
	}
	
	@Override
	public int remove(Long id){
		return lostthingsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return lostthingsDao.batchRemove(ids);
	}
	
}
