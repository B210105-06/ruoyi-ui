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


import com.dao.YonghudiancanDao;
import com.entity.YonghudiancanEntity;
import com.service.YonghudiancanService;
import com.entity.vo.YonghudiancanVO;
import com.entity.view.YonghudiancanView;

@Service("yonghudiancanService")
public class YonghudiancanServiceImpl extends ServiceImpl<YonghudiancanDao, YonghudiancanEntity> implements YonghudiancanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghudiancanEntity> page = this.selectPage(
                new Query<YonghudiancanEntity>(params).getPage(),
                new EntityWrapper<YonghudiancanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghudiancanEntity> wrapper) {
		  Page<YonghudiancanView> page =new Query<YonghudiancanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YonghudiancanVO> selectListVO(Wrapper<YonghudiancanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghudiancanVO selectVO(Wrapper<YonghudiancanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghudiancanView> selectListView(Wrapper<YonghudiancanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghudiancanView selectView(Wrapper<YonghudiancanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
