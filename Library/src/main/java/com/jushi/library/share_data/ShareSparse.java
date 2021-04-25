package com.jushi.library.share_data;

import android.util.SparseArray;
import com.jushi.library.share_data.share_msg.ShareData;
import com.alibaba.fastjson.JSONObject;
import com.jushi.library.share_data.share_msg.ShareDataDb;

public class ShareSparse {
    /**
     * USER类型
     */
    public static final String USER_CLS = "1";


    /**
     * 存放数据的对象
     */
    public static final SparseArray<Object> MUSLIM_DATA = new SparseArray();

    /**
     * 根据上面定义的常量获取对象
     *
     * @param key 关键key
     */
    public static Object getValueBy(String key) {
        if (null == MUSLIM_DATA.get(Integer.valueOf(key))) {
            putValue(key, getDbValueBy(key));
        }
        return MUSLIM_DATA.get(Integer.valueOf(key));
    }


    /**
     * 根据上面定义的常量从数据库获取
     *
     * @param key 关键key
     */
    public static Object getDbValueBy(String key) {
        return ShareDataDb.getInstance().queryBy(key);
    }


    /**
     * set全局db变量
     *
     * @param key 关键key
     * @param any 数据源
     */
    public static void putDbValue(String key, Object any) {
        ShareDataDb.getInstance().saveOrUpdate(new ShareData(key, JSONObject.toJSONString(any)));
    }

    /**
     * 是否需要保持数据到本地
     *
     * @param key       key
     * @param any       数据源
     */
    public static void putValue(String key, Object any) {
        MUSLIM_DATA.put(Integer.valueOf(key), any);
    }

    /**
     * 是否需要保持数据到本地
     *
     * @param key       key
     * @param any       数据源
     * @param saveLocal 是否需要缓冲处理
     */
    public static void putValue(String key, Object any, Boolean saveLocal) {
        if (saveLocal) {
            putDbValue(key, any);
        }
        MUSLIM_DATA.put(Integer.valueOf(key), any);
    }
}
