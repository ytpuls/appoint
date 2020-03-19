package com.school.appoint.common.service;

import com.school.appoint.common.domain.LogDO;
import com.school.appoint.common.domain.PageDO;
import com.school.appoint.common.utils.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
