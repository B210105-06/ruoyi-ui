package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZizhuqucanDao;
import com.entity.ZizhuqucanEntity;
import com.service.ZizhuqucanService;
import com.entity.vo.ZizhuqucanVO;
import com.entity.view.ZizhuqucanView;

@Service("zizhuqucanService")
public class ZizhuqucanServiceImpl extends ServiceImpl<ZizhuqucanDao, ZizhuqucanEntity> implements ZizhuqucanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZizhuqucanEntity> page = this.selectPage(
                new Query<ZizhuqucanEntity>(params).getPage(),
                new EntityWrapper<ZizhuqucanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZizhuqucanEntity> wrapper) {
		  Page<ZizhuqucanView> page =new Query<ZizhuqucanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZizhuqucanVO> selectListVO(Wrapper<ZizhuqucanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZizhuqucanVO selectVO(Wrapper<ZizhuqucanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZizhuqucanView> selectListView(Wrapper<ZizhuqucanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZizhuqucanView selectView(Wrapper<ZizhuqucanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ZizhuqucanEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ZizhuqucanEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }
    
    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ZizhuqucanEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
