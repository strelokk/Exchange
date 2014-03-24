package com.exchange.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.exchange.dao.Branch;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table BRANCH.
*/
public class BranchDao extends AbstractDao<Branch, Long> {

    public static final String TABLENAME = "BRANCH";

    /**
     * Properties of entity Branch.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Latitude = new Property(2, Double.class, "latitude", false, "LATITUDE");
        public final static Property Longitude = new Property(3, Double.class, "longitude", false, "LONGITUDE");
        public final static Property Address = new Property(4, String.class, "address", false, "ADDRESS");
        public final static Property BankId = new Property(5, long.class, "bankId", false, "BANK_ID");
    };

    private Query<Branch> bank_BranchListQuery;

    public BranchDao(DaoConfig config) {
        super(config);
    }
    
    public BranchDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'BRANCH' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'NAME' TEXT NOT NULL ," + // 1: name
                "'LATITUDE' REAL," + // 2: latitude
                "'LONGITUDE' REAL," + // 3: longitude
                "'ADDRESS' TEXT," + // 4: address
                "'BANK_ID' INTEGER NOT NULL );"); // 5: bankId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'BRANCH'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Branch entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(3, latitude);
        }
 
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(4, longitude);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
        stmt.bindLong(6, entity.getBankId());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Branch readEntity(Cursor cursor, int offset) {
        Branch entity = new Branch( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2), // latitude
            cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3), // longitude
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // address
            cursor.getLong(offset + 5) // bankId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Branch entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setLatitude(cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2));
        entity.setLongitude(cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3));
        entity.setAddress(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setBankId(cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Branch entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Branch entity) {
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
    
    /** Internal query to resolve the "branchList" to-many relationship of Bank. */
    public List<Branch> _queryBank_BranchList(long bankId) {
        synchronized (this) {
            if (bank_BranchListQuery == null) {
                QueryBuilder<Branch> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.BankId.eq(null));
                bank_BranchListQuery = queryBuilder.build();
            }
        }
        Query<Branch> query = bank_BranchListQuery.forCurrentThread();
        query.setParameter(0, bankId);
        return query.list();
    }

}
