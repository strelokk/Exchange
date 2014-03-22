package com.exchange.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

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
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Purchase = new Property(1, Float.class, "purchase", false, "PURCHASE");
        public final static Property Sale = new Property(2, Float.class, "sale", false, "SALE");
        public final static Property UpdatedDate = new Property(3, java.util.Date.class, "updatedDate", false, "UPDATED_DATE");
        public final static Property CourseId = new Property(4, Long.class, "courseId", false, "COURSE_ID");
        public final static Property BankId = new Property(5, Long.class, "bankId", false, "BANK_ID");
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
                "'_id' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'PURCHASE' REAL," + // 1: purchase
                "'SALE' REAL," + // 2: sale
                "'UPDATED_DATE' INTEGER," + // 3: updatedDate
                "'COURSE_ID' INTEGER," + // 4: courseId
                "'BANK_ID' INTEGER);"); // 5: bankId
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
        stmt.bindLong(1, entity.getId());
 
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
 
        Long courseId = entity.getCourseId();
        if (courseId != null) {
            stmt.bindLong(5, courseId);
        }
 
        Long bankId = entity.getBankId();
        if (bankId != null) {
            stmt.bindLong(6, bankId);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public CourseValue readEntity(Cursor cursor, int offset) {
        CourseValue entity = new CourseValue( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getFloat(offset + 1), // purchase
            cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2), // sale
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // updatedDate
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // courseId
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5) // bankId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, CourseValue entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setPurchase(cursor.isNull(offset + 1) ? null : cursor.getFloat(offset + 1));
        entity.setSale(cursor.isNull(offset + 2) ? null : cursor.getFloat(offset + 2));
        entity.setUpdatedDate(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setCourseId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setBankId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
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