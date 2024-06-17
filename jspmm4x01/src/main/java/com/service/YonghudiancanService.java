package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghudiancanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghudiancanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghudiancanView;


/**
 * 用户点餐
 *
 * @author 
 * @email 
 * @date 2022-08-03 19:32:36
 */
public interface YonghudiancanService extends IService<YonghudiancanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghudiancanVO> selectListVO(Wrapper<YonghudiancanEntity> wrapper);
   	
   	YonghudiancanVO selectVO(@Param("ew") Wrapper<YonghudiancanEntity> wrapper);
   	
   	List<YonghudiancanView> selectListView(Wrapper<YonghudiancanEntity> wrapper);
   	
   	YonghudiancanView selectView(@Param("ew") Wrapper<YonghudiancanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghudiancanEntity> wrapper);
   	

}

