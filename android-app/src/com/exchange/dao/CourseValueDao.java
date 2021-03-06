package com.exchange.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.exchange.dao.CourseValue;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table COURSE_VALUE.
*/
public class CourseValueDao extends AbstractDao<CourseValue, Long> {

    public static final String TABLENAME = "COURSE_VALUE";

    /**
     * Properties of entity CourseValue.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Purchase = new Property(1, Float.class, "purchase", false, "PURCHASE");
        public final static Property Sale = new Property(2, Float.class, "sale", false, "SALE");
        public final static Property UpdatedDate = new Property(3, java.util.Date.class, "updatedDate", false, "UPDATED_DATE");
        public final static Property CourseCode = new Property(4, String.class, "courseCode", false, "COURSE_CODE");
        public final static Property BankName = new Property(5, String.class, "bankName", false, "BANK_NAME");
    };


    public CourseValueDao(DaoConfig config) {
        super(config);
    }
    
    public CourseValueDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'COURSE_VALUE' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'PURCHASE' REAL," + // 1: purchase
                "'SALE' REAL," + // 2: sale
                "'UPDATED_DATE' INTEGER," + // 3: updatedDate
                "'COURSE_CODE' TEXT," + // 4: courseCode
                "'BANK_NAME' TEXT);"); // 5: bankName
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'COURSE_VALUE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, CourseValue entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Float purchase = entity.getPurchase();
        if (purchase != null) {
            stmt.bindDouble(2, purchase);
        }
 
        Float sale = entity.getSale();
        if (sale != null) {
            stmt.bindDouble(3, sale);
        }
 
        java.util.Date updatedDate = entity.getUpdatedDate();
        if (updatedDate != null) {
            stmt.bindLong(4, updatedDate.getTime());
        }
 
        String courseCode = entity.getCourseCode();
        if (courseCode != null) {
            stmt.bindString(5, courseCode);
        }
 
        String bankName = entity.getBankName();
        if (bankName != null) {
            stmt.bindString(6, bankName);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public CourseValue readEntity(Cursor cursor, int offset) {
        CourseValue entity = new CourseValue( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getFloat(offset + 1), // purchase
            cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2), // sale
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // updatedDate
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // courseCode
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // bankName
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, CourseValue entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPurchase(cursor.isNull(offset + 1) ? null : cursor.getFloat(offset + 1));
        entity.setSale(cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2));
        entity.setUpdatedDate(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setCourseCode(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setBankName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(CourseValue entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(CourseValue entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
