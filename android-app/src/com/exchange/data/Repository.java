package com.exchange.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.exchange.dao.CourseValue;
import com.exchange.dao.CourseValueDao;
import com.exchange.dao.DaoMaster;
import com.exchange.dao.DaoSession;
import com.exchange.exceptions.WrongIdException;

import java.util.List;

import de.greenrobot.dao.DaoException;

/**
 * @author vlad.fargutu
 */
public class Repository {

    private SQLiteDatabase db;
    private Context context;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public Repository(Context context) {
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
            daoMaster = new DaoMaster(db);
        }
    }

    /**
     * Check if the DataBase can be accessed.
     */
    private boolean isDbAvailable() {
        return db != null && daoMaster != null;
    }

    /**
     * Insert an entity into DataBase.
     *
     * @param entity the entity to insert.
     * @return the id of the inserted entity or -1 if a problem occurred.
     */
    public <T> long insert(T entity) {
        long id = -1L;

        if (isDbAvailable()) {
            daoSession = daoMaster.newSession();
            id = daoSession.insert(entity);
            daoSession.clear();
            daoSession = null;
        }
        return id;
    }

    /**
     * Get the entity with the given id.
     *
     * @param entityClass the entity class to search for.
     * @param id          the id of the entity to search for.
     * @return the found entity or null if the id is null or the DataBase can not be accessed.
     */
    public <T> T getById(Class<T> entityClass, Long id) throws WrongIdException {
        T result = null;

        if (id == null) {
            throw new WrongIdException();
        }

        if (isDbAvailable()) {
            daoSession = daoMaster.newSession();
            result = daoSession.load(entityClass, id);
            daoSession.clear();
            daoSession = null;
        }
        return result;
    }

    /**
     * Get the CourseValue with the given code and Bank name.
     *
     * @param code     the code of the Course to search value for.
     * @param bankName the Bank name to which belongs the Course.
     * @return a Course entity if a result was found or null otherwise.
     */
    public CourseValue getCourseValue(String code, String bankName) {
        CourseValue result = null;

        if (code == null || bankName == null) {
            return null;
        }

        if (isDbAvailable()) {
            daoSession = daoMaster.newSession();
            try {
                result = daoSession.queryBuilder(CourseValue.class).where(CourseValueDao.Properties.CourseCode.eq(code), CourseValueDao.Properties.BankName.eq(bankName)).build().unique();
            } catch (DaoException e) {
                return null;
            }
            daoSession.clear();
            daoSession = null;
        }
        return result;
    }

    /**
     * Get all entities that match's this type.
     *
     * @param entityClass the type of the entity class to search for.
     * @return the found entity or null if the id is null or the DataBase can not be accessed.
     */
    public <T> List<T> getAll(Class<T> entityClass) {
        List<T> result = null;

        if (isDbAvailable()) {
            daoSession = daoMaster.newSession();
            result = daoSession.loadAll(entityClass);
            daoSession.clear();
            daoSession = null;
        }
        return result;
    }

    /**
     * Update the given entity.
     *
     * @param entity the entity to be updated.
     * @return true if the entity was updated successfully or false otherwise.
     */
    public <T> boolean update(T entity) {
        if (entity != null && isDbAvailable()) {
            daoSession = daoMaster.newSession();
            daoSession.update(entity);
            daoSession.clear();
            daoSession = null;
            return true;
        }
        return false;
    }

    /**
     * Delete the given entity from the DataBase.
     *
     * @param entity the entity to be deleted.
     * @return true if the entity was deleted successfully or false otherwise.
     */
    public <T> boolean delete(T entity) {
        if (entity != null && isDbAvailable()) {
            daoSession = daoMaster.newSession();
            daoSession.delete(entity);
            daoSession.clear();
            daoSession = null;
            return true;
        }
        return false;
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
