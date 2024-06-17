package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanjiequEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DingdanjiequVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanjiequView;


/**
 * 订单接取
 *
 * @author 
 * @email 
 * @date 2022-08-03 19:32:36
 */
public interface DingdanjiequService extends IService<DingdanjiequEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanjiequVO> selectListVO(Wrapper<DingdanjiequEntity> wrapper);
   	
   	DingdanjiequVO selectVO(@Param("ew") Wrapper<DingdanjiequEntity> wrapper);
   	
   	List<DingdanjiequView> selectListView(Wrapper<DingdanjiequEntity> wrapper);
   	
   	DingdanjiequView selectView(@Param("ew") Wrapper<DingdanjiequEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanjiequEntity> wrapper);
   	

}

