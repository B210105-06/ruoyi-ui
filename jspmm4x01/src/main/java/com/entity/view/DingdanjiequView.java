package com.entity.view;

import com.entity.DingdanjiequEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 订单接取
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-08-03 19:32:36
 */
@TableName("dingdanjiequ")
public class DingdanjiequView  extends DingdanjiequEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DingdanjiequView(){
	}
 
 	public DingdanjiequView(DingdanjiequEntity dingdanjiequEntity){
 	try {
			BeanUtils.copyProperties(this, dingdanjiequEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
