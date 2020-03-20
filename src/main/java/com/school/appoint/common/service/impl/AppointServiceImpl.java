package com.school.appoint.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.school.appoint.common.dao.AppointDao;
import com.school.appoint.common.domain.AppointDO;
import com.school.appoint.common.service.AppointService;



@Service
public class AppointServiceImpl implements AppointService {
	@Autowired
	private AppointDao appointDao;
	
	@Override
	public AppointDO get(Integer id){
		return appointDao.get(id);
	}
	
	@Override
	public List<AppointDO> list(Map<String, Object> map){
		return appointDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return appointDao.count(map);
	}
	
	@Override
	public int save(AppointDO appoint){
		return appointDao.save(appoint);
	}
	
	@Override
	public int update(AppointDO appoint){
		return appointDao.update(appoint);
	}
	
	@Override
	public int remove(Integer id){
		return appointDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return appointDao.batchRemove(ids);
	}
	
}
