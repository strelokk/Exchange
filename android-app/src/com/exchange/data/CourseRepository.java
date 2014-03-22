package com.exchange.data;

import android.content.Context;

import com.exchange.dao.Course;
import com.exchange.dao.CourseDao;
import com.exchange.dao.DaoMaster;
import com.exchange.dao.DaoSession;
import com.exchange.exceptions.WrongIdException;

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
    public Course getById(Long id) throws WrongIdException {
        if (id == null) {
            throw new WrongIdException();
        }

        if (db != null) {
            Course course = null;
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            CourseDao courseDao = daoSession.getCourseDao();
            course = courseDao.load(id);
            daoSession.clear();
            daoMaster = null;

            if (course == null) {
                throw new WrongIdException();
            }
            return course;
        }

        return null;
    }

    /**
     * Insert a Course entity into DataBase.
     *
     * @param course the Course entity to insert.
     * @return the id of the inserted entity or -1 if a problem occurred.
     */
    public Long insert(Course course) {
        if (course == null) {
            return -1L;
        }

        if (db != null) {
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            CourseDao courseDao = daoSession.getCourseDao();
            Long id = courseDao.insert(course);
            daoSession.clear();
            daoMaster = null;
            return id;
        }

        return -1L;
    }

}
