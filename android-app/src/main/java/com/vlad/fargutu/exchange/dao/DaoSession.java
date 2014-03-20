package com.vlad.fargutu.exchange.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.vlad.fargutu.exchange.dao.Course;
import com.vlad.fargutu.exchange.dao.CourseValue;
import com.vlad.fargutu.exchange.dao.Branch;
import com.vlad.fargutu.exchange.dao.Bank;

import com.vlad.fargutu.exchange.dao.CourseDao;
import com.vlad.fargutu.exchange.dao.CourseValueDao;
import com.vlad.fargutu.exchange.dao.BranchDao;
import com.vlad.fargutu.exchange.dao.BankDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig courseDaoConfig;
    private final DaoConfig courseValueDaoConfig;
    private final DaoConfig branchDaoConfig;
    private final DaoConfig bankDaoConfig;

    private final CourseDao courseDao;
    private final CourseValueDao courseValueDao;
    private final BranchDao branchDao;
    private final BankDao bankDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        courseDaoConfig = daoConfigMap.get(CourseDao.class).clone();
        courseDaoConfig.initIdentityScope(type);

        courseValueDaoConfig = daoConfigMap.get(CourseValueDao.class).clone();
        courseValueDaoConfig.initIdentityScope(type);

        branchDaoConfig = daoConfigMap.get(BranchDao.class).clone();
        branchDaoConfig.initIdentityScope(type);

        bankDaoConfig = daoConfigMap.get(BankDao.class).clone();
        bankDaoConfig.initIdentityScope(type);

        courseDao = new CourseDao(courseDaoConfig, this);
        courseValueDao = new CourseValueDao(courseValueDaoConfig, this);
        branchDao = new BranchDao(branchDaoConfig, this);
        bankDao = new BankDao(bankDaoConfig, this);

        registerDao(Course.class, courseDao);
        registerDao(CourseValue.class, courseValueDao);
        registerDao(Branch.class, branchDao);
        registerDao(Bank.class, bankDao);
    }
    
    public void clear() {
        courseDaoConfig.getIdentityScope().clear();
        courseValueDaoConfig.getIdentityScope().clear();
        branchDaoConfig.getIdentityScope().clear();
        bankDaoConfig.getIdentityScope().clear();
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

    public CourseValueDao getCourseValueDao() {
        return courseValueDao;
    }

    public BranchDao getBranchDao() {
        return branchDao;
    }

    public BankDao getBankDao() {
        return bankDao;
    }

}
