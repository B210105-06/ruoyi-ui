package com.dao;

import com.entity.DingdanjiequEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingdanjiequVO;
import com.entity.view.DingdanjiequView;


/**
 * 订单接取
 * 
 * @author 
 * @email 
 * @date 2022-08-03 19:32:36
 */
public interface DingdanjiequDao extends BaseMapper<DingdanjiequEntity> {
	
	List<DingdanjiequVO> selectListVO(@Param("ew") Wrapper<DingdanjiequEntity> wrapper);
	
	DingdanjiequVO selectVO(@Param("ew") Wrapper<DingdanjiequEntity> wrapper);
	
	List<DingdanjiequView> selectListView(@Param("ew") Wrapper<DingdanjiequEntity> wrapper);

	List<DingdanjiequView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanjiequEntity> wrapper);
	
	DingdanjiequView selectView(@Param("ew") Wrapper<DingdanjiequEntity> wrapper);
	

}
