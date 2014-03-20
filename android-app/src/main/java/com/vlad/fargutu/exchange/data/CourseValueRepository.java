package com.vlad.fargutu.exchange.data;

import android.content.Context;

import com.vlad.fargutu.exchange.dao.CourseValue;
import com.vlad.fargutu.exchange.dao.CourseValueDao;
import com.vlad.fargutu.exchange.dao.DaoMaster;
import com.vlad.fargutu.exchange.dao.DaoSession;

/**
 * DAO Class for CourseValue entities.
 *
 * @author vlad.fargutu
 */
public class CourseValueRepository extends Repository {

    public CourseValueRepository(Context context) {
        super(context);
    }

    /**
     * Get the CourseValue entity with the given id.
     *
     * @return A CourseValue entity or null if the id is null or the DataBase can not be accessed.
     */
    public CourseValue getById(Long id) {
        if (id == null) {
            return null;
        }

        if (db != null) {
            CourseValue bank = null;
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            CourseValueDao courseValueDao = daoSession.getCourseValueDao();
            bank = courseValueDao.load(id);
            daoSession.clear();
            daoMaster = null;
            return bank;
        }

        return null;
    }

}
