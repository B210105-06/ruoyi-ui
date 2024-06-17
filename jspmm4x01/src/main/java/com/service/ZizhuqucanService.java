package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZizhuqucanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZizhuqucanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZizhuqucanView;


/**
 * 自主取餐
 *
 * @author 
 * @email 
 * @date 2022-08-03 19:32:36
 */
public interface ZizhuqucanService extends IService<ZizhuqucanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZizhuqucanVO> selectListVO(Wrapper<ZizhuqucanEntity> wrapper);
   	
   	ZizhuqucanVO selectVO(@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);
   	
   	List<ZizhuqucanView> selectListView(Wrapper<ZizhuqucanEntity> wrapper);
   	
   	ZizhuqucanView selectView(@Param("ew") Wrapper<ZizhuqucanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZizhuqucanEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ZizhuqucanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ZizhuqucanEntity> wrapper);
    
    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ZizhuqucanEntity> wrapper);
}

