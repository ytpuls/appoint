package com.school.appoint.common.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.appoint.common.domain.AppointDO;
import com.school.appoint.common.service.AppointService;
import com.school.appoint.common.utils.PageUtils;
import com.school.appoint.common.utils.Query;
import com.school.appoint.common.utils.R;

/**
 * 
 * 
 * @author yangtao
 * @email 541502337@qq.com
 * @date 2020-03-20 16:42:48
 */
 
@Controller
@RequestMapping("/common/appoint")
public class AppointController {

	@Autowired
	private AppointService appointService;
	
	@GetMapping()
	@RequiresPermissions("common:appoint:appoint")
	String Appoint(){
	    return "common/appoint/appoint";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:appoint:appoint")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AppointDO> appointList = appointService.list(query);
		int total = appointService.count(query);
		PageUtils pageUtils = new PageUtils(appointList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:appoint:add")
	String add(){
	    return "common/appoint/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:appoint:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		AppointDO appoint = appointService.get(id);
		model.addAttribute("appoint", appoint);
	    return "common/appoint/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:appoint:add")
	public R save( AppointDO appoint){
		if(appointService.save(appoint)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:appoint:edit")
	public R update( AppointDO appoint){
		appointService.update(appoint);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:appoint:remove")
	public R remove( Integer id){
		if(appointService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:appoint:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		appointService.batchRemove(ids);
		return R.ok();
	}
	
}
