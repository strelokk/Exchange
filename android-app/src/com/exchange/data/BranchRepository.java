package com.exchange.data;

import android.content.Context;

import com.exchange.dao.Branch;
import com.exchange.dao.BranchDao;
import com.exchange.dao.DaoMaster;
import com.exchange.dao.DaoSession;
import com.exchange.exceptions.WrongIdException;

/**
 * DAO Class for Branch entities.
 *
 * @author vlad.fargutu
 */
public class BranchRepository extends Repository {

    public BranchRepository(Context context) {
        super(context);
    }

    /**
     * Get the Branch entity with the given id.
     *
     * @return A Branch entity or null if the id is null or the DataBase can not be accessed.
     */
    public Branch getById(Long id) throws WrongIdException {
        if (id == null) {
            throw new WrongIdException();
        }

        if (db != null) {
            Branch branch = null;
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            BranchDao branchDao = daoSession.getBranchDao();
            branch = branchDao.load(id);
            daoSession.clear();
            daoMaster = null;

            if (branch == null) {
                throw new WrongIdException();
            }
            return branch;
        }

        return null;
    }

    /**
     * Insert a Branch entity into DataBase.
     *
     * @param branch the Branch entity to insert.
     * @return the id of the inserted entity or -1 if a problem occurred.
     */
    public Long insert(Branch branch) {
        if (branch == null) {
            return -1L;
        }

        if (db != null) {
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            BranchDao branchDao = daoSession.getBranchDao();
            Long id = branchDao.insert(branch);
            daoSession.clear();
            daoMaster = null;
            return id;
        }

        return -1L;
    }

}
