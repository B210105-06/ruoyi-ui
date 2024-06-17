package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DingdanjiequEntity;
import com.entity.view.DingdanjiequView;

import com.service.DingdanjiequService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

@RestController
@RequestMapping("/dingdanjiequ")
public class DingdanjiequController {
    @Autowired
    private DingdanjiequService dingdanjiequService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanjiequEntity dingdanjiequ, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dingdanjiequ.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("qishou")) {
			dingdanjiequ.setQishouzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingdanjiequEntity> ew = new EntityWrapper<DingdanjiequEntity>();

    	PageUtils page = dingdanjiequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanjiequ), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanjiequEntity dingdanjiequ, 
		HttpServletRequest request){
        EntityWrapper<DingdanjiequEntity> ew = new EntityWrapper<DingdanjiequEntity>();

    	PageUtils page = dingdanjiequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanjiequ), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanjiequEntity dingdanjiequ){
       	EntityWrapper<DingdanjiequEntity> ew = new EntityWrapper<DingdanjiequEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanjiequ, "dingdanjiequ")); 
        return R.ok().put("data", dingdanjiequService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanjiequEntity dingdanjiequ){
        EntityWrapper< DingdanjiequEntity> ew = new EntityWrapper< DingdanjiequEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanjiequ, "dingdanjiequ")); 
		DingdanjiequView dingdanjiequView =  dingdanjiequService.selectView(ew);
		return R.ok("查询订单接取成功").put("data", dingdanjiequView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanjiequEntity dingdanjiequ = dingdanjiequService.selectById(id);
        return R.ok().put("data", dingdanjiequ);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanjiequEntity dingdanjiequ = dingdanjiequService.selectById(id);
        return R.ok().put("data", dingdanjiequ);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanjiequEntity dingdanjiequ, HttpServletRequest request){
    	dingdanjiequ.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanjiequ);

        dingdanjiequService.insert(dingdanjiequ);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody DingdanjiequEntity dingdanjiequ, HttpServletRequest request){
    	dingdanjiequ.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanjiequ);

        dingdanjiequService.insert(dingdanjiequ);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdanjiequEntity dingdanjiequ, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanjiequ);
        dingdanjiequService.updateById(dingdanjiequ);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanjiequService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DingdanjiequEntity> wrapper = new EntityWrapper<DingdanjiequEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("qishou")) {
			wrapper.eq("qishouzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = dingdanjiequService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
