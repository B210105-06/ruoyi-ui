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


import com.dao.DingdanjiequDao;
import com.entity.DingdanjiequEntity;
import com.service.DingdanjiequService;
import com.entity.vo.DingdanjiequVO;
import com.entity.view.DingdanjiequView;

@Service("dingdanjiequService")
public class DingdanjiequServiceImpl extends ServiceImpl<DingdanjiequDao, DingdanjiequEntity> implements DingdanjiequService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanjiequEntity> page = this.selectPage(
                new Query<DingdanjiequEntity>(params).getPage(),
                new EntityWrapper<DingdanjiequEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanjiequEntity> wrapper) {
		  Page<DingdanjiequView> page =new Query<DingdanjiequView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DingdanjiequVO> selectListVO(Wrapper<DingdanjiequEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingdanjiequVO selectVO(Wrapper<DingdanjiequEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingdanjiequView> selectListView(Wrapper<DingdanjiequEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanjiequView selectView(Wrapper<DingdanjiequEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
