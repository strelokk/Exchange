package com.vlad.fargutu.exchange.data;

import android.content.Context;

import com.vlad.fargutu.exchange.dao.Branch;
import com.vlad.fargutu.exchange.dao.BranchDao;
import com.vlad.fargutu.exchange.dao.DaoMaster;
import com.vlad.fargutu.exchange.dao.DaoSession;

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
    public Branch getById(Long id) {
        if (id == null) {
            return null;
        }

        if (db != null) {
            Branch bank = null;
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            BranchDao branchDao = daoSession.getBranchDao();
            bank = branchDao.load(id);
            daoSession.clear();
            daoMaster = null;
            return bank;
        }

        return null;
    }

}
