package com.school.appoint.common.service.impl;

import com.school.appoint.common.dao.MessageDao;
import com.school.appoint.common.domain.MessageDO;
import com.school.appoint.common.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public MessageDO get(Long id){
		return messageDao.get(id);
	}
	
	@Override
	public List<MessageDO> list(Map<String, Object> map){
		return messageDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return messageDao.count(map);
	}
	
	@Override
	public int save(MessageDO message){
		return messageDao.save(message);
	}
	
	@Override
	public int update(MessageDO message){
		return messageDao.update(message);
	}
	
	@Override
	public int remove(Long id){
		return messageDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return messageDao.batchRemove(ids);
	}
	
}
