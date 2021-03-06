package com.jushi.library.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jushi.library.share_data.share_msg.ShareData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SHARE_DATA".
*/
public class ShareDataDao extends AbstractDao<ShareData, String> {

    public static final String TABLENAME = "SHARE_DATA";

    /**
     * Properties of entity ShareData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Msg = new Property(1, String.class, "msg", false, "MSG");
        public final static Property RemarkA = new Property(2, String.class, "remarkA", false, "REMARK_A");
        public final static Property RemarkB = new Property(3, String.class, "remarkB", false, "REMARK_B");
        public final static Property RemarkC = new Property(4, String.class, "remarkC", false, "REMARK_C");
        public final static Property RemarkD = new Property(5, String.class, "remarkD", false, "REMARK_D");
        public final static Property RemarkE = new Property(6, String.class, "remarkE", false, "REMARK_E");
        public final static Property RemarkF = new Property(7, String.class, "remarkF", false, "REMARK_F");
        public final static Property RemarkG = new Property(8, String.class, "remarkG", false, "REMARK_G");
        public final static Property RemarkH = new Property(9, String.class, "remarkH", false, "REMARK_H");
        public final static Property RemarkK = new Property(10, String.class, "remarkK", false, "REMARK_K");
        public final static Property RemarkM = new Property(11, String.class, "remarkM", false, "REMARK_M");
    }


    public ShareDataDao(DaoConfig config) {
        super(config);
    }
    
    public ShareDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SHARE_DATA\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"MSG\" TEXT," + // 1: msg
                "\"REMARK_A\" TEXT," + // 2: remarkA
                "\"REMARK_B\" TEXT," + // 3: remarkB
                "\"REMARK_C\" TEXT," + // 4: remarkC
                "\"REMARK_D\" TEXT," + // 5: remarkD
                "\"REMARK_E\" TEXT," + // 6: remarkE
                "\"REMARK_F\" TEXT," + // 7: remarkF
                "\"REMARK_G\" TEXT," + // 8: remarkG
                "\"REMARK_H\" TEXT," + // 9: remarkH
                "\"REMARK_K\" TEXT," + // 10: remarkK
                "\"REMARK_M\" TEXT);"); // 11: remarkM
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SHARE_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ShareData entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String msg = entity.getMsg();
        if (msg != null) {
            stmt.bindString(2, msg);
        }
 
        String remarkA = entity.getRemarkA();
        if (remarkA != null) {
            stmt.bindString(3, remarkA);
        }
 
        String remarkB = entity.getRemarkB();
        if (remarkB != null) {
            stmt.bindString(4, remarkB);
        }
 
        String remarkC = entity.getRemarkC();
        if (remarkC != null) {
            stmt.bindString(5, remarkC);
        }
 
        String remarkD = entity.getRemarkD();
        if (remarkD != null) {
            stmt.bindString(6, remarkD);
        }
 
        String remarkE = entity.getRemarkE();
        if (remarkE != null) {
            stmt.bindString(7, remarkE);
        }
 
        String remarkF = entity.getRemarkF();
        if (remarkF != null) {
            stmt.bindString(8, remarkF);
        }
 
        String remarkG = entity.getRemarkG();
        if (remarkG != null) {
            stmt.bindString(9, remarkG);
        }
 
        String remarkH = entity.getRemarkH();
        if (remarkH != null) {
            stmt.bindString(10, remarkH);
        }
 
        String remarkK = entity.getRemarkK();
        if (remarkK != null) {
            stmt.bindString(11, remarkK);
        }
 
        String remarkM = entity.getRemarkM();
        if (remarkM != null) {
            stmt.bindString(12, remarkM);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ShareData entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String msg = entity.getMsg();
        if (msg != null) {
            stmt.bindString(2, msg);
        }
 
        String remarkA = entity.getRemarkA();
        if (remarkA != null) {
            stmt.bindString(3, remarkA);
        }
 
        String remarkB = entity.getRemarkB();
        if (remarkB != null) {
            stmt.bindString(4, remarkB);
        }
 
        String remarkC = entity.getRemarkC();
        if (remarkC != null) {
            stmt.bindString(5, remarkC);
        }
 
        String remarkD = entity.getRemarkD();
        if (remarkD != null) {
            stmt.bindString(6, remarkD);
        }
 
        String remarkE = entity.getRemarkE();
        if (remarkE != null) {
            stmt.bindString(7, remarkE);
        }
 
        String remarkF = entity.getRemarkF();
        if (remarkF != null) {
            stmt.bindString(8, remarkF);
        }
 
        String remarkG = entity.getRemarkG();
        if (remarkG != null) {
            stmt.bindString(9, remarkG);
        }
 
        String remarkH = entity.getRemarkH();
        if (remarkH != null) {
            stmt.bindString(10, remarkH);
        }
 
        String remarkK = entity.getRemarkK();
        if (remarkK != null) {
            stmt.bindString(11, remarkK);
        }
 
        String remarkM = entity.getRemarkM();
        if (remarkM != null) {
            stmt.bindString(12, remarkM);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public ShareData readEntity(Cursor cursor, int offset) {
        ShareData entity = new ShareData( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // msg
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // remarkA
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // remarkB
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // remarkC
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // remarkD
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // remarkE
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // remarkF
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // remarkG
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // remarkH
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // remarkK
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11) // remarkM
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ShareData entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setMsg(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRemarkA(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRemarkB(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setRemarkC(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRemarkD(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRemarkE(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setRemarkF(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setRemarkG(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setRemarkH(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setRemarkK(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setRemarkM(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
     }
    
    @Override
    protected final String updateKeyAfterInsert(ShareData entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public String getKey(ShareData entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ShareData entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
