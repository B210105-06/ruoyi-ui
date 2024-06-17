package com.dao;

import com.entity.YonghudiancanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghudiancanVO;
import com.entity.view.YonghudiancanView;


/**
 * 用户点餐
 * 
 * @author 
 * @email 
 * @date 2022-08-03 19:32:36
 */
public interface YonghudiancanDao extends BaseMapper<YonghudiancanEntity> {
	
	List<YonghudiancanVO> selectListVO(@Param("ew") Wrapper<YonghudiancanEntity> wrapper);
	
	YonghudiancanVO selectVO(@Param("ew") Wrapper<YonghudiancanEntity> wrapper);
	
	List<YonghudiancanView> selectListView(@Param("ew") Wrapper<YonghudiancanEntity> wrapper);

	List<YonghudiancanView> selectListView(Pagination page,@Param("ew") Wrapper<YonghudiancanEntity> wrapper);
	
	YonghudiancanView selectView(@Param("ew") Wrapper<YonghudiancanEntity> wrapper);
	

}
