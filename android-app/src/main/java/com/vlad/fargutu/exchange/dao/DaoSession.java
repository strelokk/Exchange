package com.vlad.fargutu.exchange.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 *
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig uploadDaoConfig;

    private final UploadDao uploadDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        uploadDaoConfig = daoConfigMap.get(UploadDao.class).clone();
        uploadDaoConfig.initIdentityScope(type);

        uploadDao = new UploadDao(uploadDaoConfig, this);

        registerDao(Upload.class, uploadDao);
    }

    public void clear() {
        uploadDaoConfig.getIdentityScope().clear();
    }

    public UploadDao getUploadDao() {
        return uploadDao;
    }

}