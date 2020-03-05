package com.example.demo4.utils;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class MsgKits {

	/**
	 *	 请求数据返回map
	 * @param code 全局返回碼
	 * @param msg 返回消息
	 * @param type 類型
	 * @param data 數據
	 * @return Map<String,String> 状态码+提示消息+设备类型+回传数据
	 */
	public static Map<String,Object> replyMap(String code,String msg,String type,Object data) {
		String type_default_ornew = type == null ? "-" : type;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("msg", msg);
		map.put("type", type_default_ornew);
		map.put("data", data);
		return map;
	}
	
	/**
	 * java对象转JSONObject对象
	 * @param obj
	 * @return
	 */
	public static JSONObject obj2jsonObj(Object obj) {
		String jsonStr = JSONObject.toJSONString(obj);
		JSONObject jsonObj = JSONObject.parseObject(jsonStr);
		return jsonObj;
	}

	/**
	 * 创建订单号：日期到分+4位随机数
	 * e.g. 2019061509404511
	 * @return
	 */
	public static String createBillno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		//当前日期字符串（到分24小时制）
		String dateStr = sdf.format(new Date());
		//四位随机数
		Integer rnd4bit = (int) Math.floor(Math.random() * 9000 + 1000);
		//工单号
		String billNo = dateStr + String.valueOf(rnd4bit);
		return billNo;
	}
	
	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Boolean isEmpty(Object... objs) {
		if (objs == null || objs.length == 0)
			return true;
		for (Object obj : objs) {
			if (obj == null)
				return true;
			if (obj instanceof String && "".equals(((String) obj).trim()))
				return true;
			if (obj instanceof Collection && ((Collection) obj).isEmpty())
				return true;
		}

		return false;
	}
	
	/**
     * 判断对象中属性值是否全为空
     *
     * @param object
     * @return
     */
    public static boolean innerFieldsAllEmpty(Object object) {
    	if (null == object) {
        	return true;
        }
        try {
        	for (Field f : object.getClass().getDeclaredFields()) {
        		f.setAccessible(true);//开放私有字段
        		//字段名--f.getName();
        		//字段值--f.get(object);
				if (f.get(object) != null && !"".equals(f.get(object).toString())) {
					return false;
				}
        	}
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
        return true;
    }
    
    /**
     * 判斷對象中存在空屬性值
     * @param object
     * @return
     */
    public static boolean existNullInnerField(Object object) {
    	if (null == object) {
        	return true;
        }
        try {
        	for (Field f : object.getClass().getDeclaredFields()) {
        		f.setAccessible(true);//开放私有字段
        		//字段名--f.getName();
        		//字段值--f.get(object);
				if (f.get(object) == null || "".equals(f.get(object).toString())) {
					return true;
				}
        	}
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
        return false;
    }
    
    /**
     * 給定日期當天零點
     * @author C3901094 
     * @date 2019年10月30日 下午2:14:59
     * @param date
     * @return
     */
    public static Date getBeginOfThisDate(Date date) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	//當日時間(00:00:00)
    	c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
    	Date dayBegin = c.getTime();
    	return dayBegin;
    }
    /**
     * 給定日期當天23点59分59秒
     * @author C3901094 
     * @date 2019年10月30日 下午2:15:14
     * @param date
     * @return
     */
    public static Date getEndOfThisDate(Date date) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	//當日時間(23:59:59)
    	c.set(Calendar.HOUR_OF_DAY, 23);
    	c.set(Calendar.MINUTE, 59);
    	c.set(Calendar.SECOND, 59);
    	return c.getTime();
    }
    
    /**
     * 獲取給定月份第一天零点的日期
     * @param date
     * @return
     */
    public static Date getBeginOfTheMonth(Date date) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	//給定月份第一天零点的日期
    	c.set(Calendar.DAY_OF_MONTH, 1);
    	c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
    	Date startDate = c.getTime();
    	return startDate;
    }
    
    /**
     * 獲取給定月份最後一天23点59分59秒日期
     * @param date
     * @return
     */
    public static Date getEndOfTheMonth(Date date) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	//給定月份最後一天23点59分59秒日期
    	c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
    	c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
    	Date endDate = c.getTime();
    	return endDate;
    }

    /**
     * 生成UUID+4位隨機數(去除uuid中的"-"符号)
     * @author C3901094 
     * @date 2019年10月24日 下午2:50:35
     * @return
     */
	public static String createRandomId() {
		Integer rnd4bit = (int) Math.floor(Math.random() * 9000 + 1000);
		String id = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() + rnd4bit;
		return id;
	}
   
}
