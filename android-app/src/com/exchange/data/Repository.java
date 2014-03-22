package com.exchange.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.exchange.dao.DaoMaster;

/**
 * @author vlad.fargutu
 */
public class Repository {

    protected SQLiteDatabase db;
    private Context context;

    protected Repository(Context context) {
        this.context = context;
        initDatabase();
    }

    /**
     * Initialize the database connection and create dao access for banks.
     */
    private void initDatabase() {
        DaoMaster.DevOpenHelper mHelper = DbManager.getInstance(context).getPersistenceHelper();

        if (mHelper != null) {
            db = mHelper.getWritableDatabase();
            DaoMaster.createAllTables(db, true);
        }
    }

    /**
     * Close database connection
     */
    public void closeDb() {
        if (db != null) {
            db.close();
        }
    }

}
