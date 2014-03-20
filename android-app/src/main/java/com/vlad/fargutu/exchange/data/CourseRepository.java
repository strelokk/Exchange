package com.vlad.fargutu.exchange.data;

import android.content.Context;

import com.vlad.fargutu.exchange.dao.Course;
import com.vlad.fargutu.exchange.dao.CourseDao;
import com.vlad.fargutu.exchange.dao.DaoMaster;
import com.vlad.fargutu.exchange.dao.DaoSession;

/**
 * DAO Class for Course entities.
 *
 * @author vlad.fargutu
 */
public class CourseRepository extends Repository {

    public CourseRepository(Context context) {
        super(context);
    }

    /**
     * Get the Course entity with the given id.
     *
     * @return A Course entity or null if the id is null or the DataBase can not be accessed.
     */
    public Course getById(Long id) {
        if (id == null) {
            return null;
        }

        if (db != null) {
            Course bank = null;
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            CourseDao courseDao = daoSession.getCourseDao();
            bank = courseDao.load(id);
            daoSession.clear();
            daoMaster = null;
            return bank;
        }

        return null;
    }

}
