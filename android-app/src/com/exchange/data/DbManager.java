package com.exchange.data;

import android.content.Context;

import com.exchange.dao.DaoMaster;

/**
 * Created by vlad.fargutu on 3/20/14.
 */
public class DbManager {

    private static com.exchange.data.DbManager instance;

    private DaoMaster.DevOpenHelper persistenceHelper;

    private DbManager(Context context) {
        super();

        if (context == null) {
            return;
        }

        initPersistenceHelper(context);
    }

    public static com.exchange.data.DbManager getInstance(Context context) {
        if (instance == null) {
            instance = new com.exchange.data.DbManager(context);
        }
        return instance;
    }

    public DaoMaster.DevOpenHelper getPersistenceHelper() {
        return this.persistenceHelper;
    }

    public synchronized void closePersistenceHelper() {
        if (persistenceHelper != null) {
            persistenceHelper.close();
            persistenceHelper = null;
        }
    }

    public synchronized void initPersistenceHelper(Context context) {
        if (persistenceHelper == null) {
            persistenceHelper = new DaoMaster.DevOpenHelper(context, "exchange-db", null);
        }
    }

    public synchronized void closeDbConnections() {
        closePersistenceHelper();
    }

}
