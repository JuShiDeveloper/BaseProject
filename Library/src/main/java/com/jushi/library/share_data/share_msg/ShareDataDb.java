package com.jushi.library.share_data.share_msg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.alibaba.fastjson.JSONObject;
import com.base.share_data.ShareSparse;
import com.jushi.library.base.BaseApplication;
import com.jushi.library.dao.DaoMaster;
import com.jushi.library.dao.DaoSession;
import com.jushi.library.dao.ShareDataDao;
import com.jushi.library.share_data.user.User;


/**
 * Describe:共享数据本地搜索数据处理
 * <p>
 * Created by zhigang wei
 * on 2017/6/4.
 * <p>
 * Company :cpx
 */
public class ShareDataDb {
    private static volatile ShareDataDb db;
    private final static String dbName = "lib";
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;


    private ShareDataDb() {
        context = BaseApplication.getInstance();
        openHelper = new DaoMaster.DevOpenHelper(context, dbName);
    }


    /**
     * 获取单例
     *
     * @return
     */
    public static ShareDataDb getInstance() {
        if (db == null) {
            synchronized (ShareDataDb.class) {
                if (db == null) {
                    db = new ShareDataDb();
                }
            }
        }
        return db;
    }


    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }


    public void saveOrUpdate(Object info) {
        if (info == null) return;
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShareDataDao dao = daoSession.getShareDataDao();
        if (info instanceof ShareData) {
            dao.insertOrReplace((ShareData) info);
        } else {
            ShareData data = new ShareData();
            data.setMsg(JSONObject.toJSONString(info));
            if (info instanceof User) {
                data.setId(ShareSparse.USER_CLS);
            }
            dao.insertOrReplace(data);
        }
    }


    public void delete(String id) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ShareDataDao dao = daoSession.getShareDataDao();
        dao.deleteByKey(id);
    }


    public Object queryBy(String id) {
        try {
            DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
            DaoSession daoSession = daoMaster.newSession();
            ShareDataDao dao = daoSession.getShareDataDao();
            ShareData shareData = dao.queryBuilder().where(ShareDataDao.Properties.Id.eq(id)).unique();
            if (shareData == null || isEmpty(shareData.getMsg())) return shareData;
            if (id.equals(ShareSparse.USER_CLS)) {
                return JSONObject.parseObject(shareData.getMsg(), User.class);
            }
            return shareData;
        } catch (SQLiteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 描述：判断一个字符串是否为null或空值.
     *
     * @param str 指定的字符串
     * @return true or false
     */
    private boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0 || str.equals("null");
    }
}
