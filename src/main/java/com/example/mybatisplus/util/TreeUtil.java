package com.example.mybatisplus.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author MFC
 */
public  class TreeUtil {

    public static JSONArray arrayToTree(JSONArray arr,String id,String pid,String child){
        JSONArray r = new JSONArray();
        JSONObject hash = new JSONObject();
        //将数组转为Object的形式，key为数组中的id
        for (Object o : arr) {
            JSONObject json = (JSONObject) o;
            hash.put(json.getString(id), json);
        }
        //遍历结果集
        for (Object o : arr) {
            //单条记录
            JSONObject aVal = (JSONObject) o;
            //在hash中取出key为单条记录中pid的值
            JSONObject jsonObject = (JSONObject) hash.get(aVal.getString(pid));
            //如果记录的pid存在，则说明它有父节点，将她添加到孩子节点的集合中
            if (jsonObject != null) {
                //检查是否有child属性
                if (jsonObject.get(child) != null) {
                    JSONArray ch = (JSONArray) jsonObject.get(child);
                    ch.add(aVal);
                    jsonObject.put(child, ch);
                } else {
                    JSONArray ch = new JSONArray();
                    ch.add(aVal);
                    jsonObject.put(child, ch);
                }
            } else {
                r.add(aVal);
            }
        }
        return r;
    }
}



