package com.exchange.data;

import android.content.Context;

import com.exchange.dao.CourseValue;
import com.exchange.dao.CourseValueDao;
import com.exchange.dao.DaoMaster;
import com.exchange.dao.DaoSession;
import com.exchange.exceptions.WrongIdException;

import de.greenrobot.dao.query.QueryBuilder;

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
    public CourseValue getById(Long id) throws WrongIdException {
        if (id == null) {
            throw new WrongIdException();
        }

        if (db != null) {
            CourseValue course = null;
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            CourseValueDao courseValueDao = daoSession.getCourseValueDao();
            course = courseValueDao.load(id);
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
     * Get the CourseValue entity associated with the bank with the given id.
     *
     * @return A CourseValue entity or null if the id is null or the DataBase can not be accessed.
     */
    public CourseValue getByBankId(Long bankId, Long courseId) throws WrongIdException {
        if (bankId == null || courseId == null) {
            throw new WrongIdException();
        }

        if (db != null) {
            CourseValue courseValue = null;
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            CourseValueDao courseValueDao = daoSession.getCourseValueDao();
            QueryBuilder qb = courseValueDao.queryBuilder();
            courseValue = (CourseValue) qb.where(CourseValueDao.Properties.BankId.eq(bankId)).where(CourseValueDao.Properties.CourseId.eq(courseId)).build().unique();
            daoSession.clear();
            daoMaster = null;

            if (courseValue == null) {
                throw new WrongIdException();
            }
            return courseValue;
        }

        return null;
    }

    /**
     * Insert a CourseValue entity into DataBase.
     *
     * @param courseValue the CourseValue entity to insert.
     * @return the id of the inserted entity or -1 if a problem occurred.
     */
    public Long insert(CourseValue courseValue) {
        if (courseValue == null) {
            return -1L;
        }

        if (db != null) {
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            CourseValueDao courseValueDao = daoSession.getCourseValueDao();
            Long id = courseValueDao.insert(courseValue);
            daoSession.clear();
            daoMaster = null;
            return id;
        }

        return -1L;
    }

}
