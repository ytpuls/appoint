package com.school.appoint.common.controller;

import com.school.appoint.common.domain.Constants;
import com.school.appoint.common.domain.MessageDO;
import com.school.appoint.common.service.MessageService;
import com.school.appoint.common.utils.PageUtils;
import com.school.appoint.common.utils.Query;
import com.school.appoint.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangtao
 * @email 541502337@qq.com
 * @date 2019-03-22 15:58:34
 */
 
@Controller
@RequestMapping("/common/message")
public class MessageController extends BaseController{

	@Autowired
	private MessageService messageService;
	
	@GetMapping()
	@RequiresPermissions("common:message:message")
	String Message(){
	    return "common/message/message";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:message:message")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MessageDO> messageList = messageService.list(query);
		int total = messageService.count(query);
		PageUtils pageUtils = new PageUtils(messageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:message:add")
	String add(){
	    return "common/message/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:message:edit")
	String edit(@PathVariable("id") Long id, Model model){
		MessageDO message = messageService.get(id);
		model.addAttribute("message", message);
	    return "common/message/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:message:add")
	public R save( MessageDO message){
	    message.setLeavetime(new Date());
	    message.setStatus(Constants.ENABLE);
	    message.setUsername(getUsername());
		if(messageService.save(message)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:message:edit")
	public R update( MessageDO message){
        message.setLeavetime(new Date());
        message.setStatus(Constants.ENABLE);
        message.setUsername(getUsername());
		messageService.update(message);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:message:remove")
	public R remove( Long id){
		if(messageService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:message:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		messageService.batchRemove(ids);
		return R.ok();
	}
	
}
