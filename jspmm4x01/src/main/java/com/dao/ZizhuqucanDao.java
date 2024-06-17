package com.dao;

import com.entity.ZizhuqucanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZizhuqucanVO;
import com.entity.view.ZizhuqucanView;


/**
 * 自主取餐
 * 
 * @author 
 * @email 
 * @date 2022-08-03 19:32:36
 */
public interface ZizhuqucanDao extends BaseMapper<ZizhuqucanEntity> {
	
	List<ZizhuqucanVO> selectListVO(@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);
	
	ZizhuqucanVO selectVO(@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);
	
	List<ZizhuqucanView> selectListView(@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);

	List<ZizhuqucanView> selectListView(Pagination page,@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);
	
	ZizhuqucanView selectView(@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);
    
    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);
}
