package com.vlad.fargutu.exchange.data;

import android.content.Context;

import com.vlad.fargutu.exchange.dao.Bank;
import com.vlad.fargutu.exchange.dao.BankDao;
import com.vlad.fargutu.exchange.dao.DaoMaster;
import com.vlad.fargutu.exchange.dao.DaoSession;

/**
 * DAO Class for Bank entities.
 *
 * @author vlad.fargutu
 */
public class BankRepository extends Repository {

    public BankRepository(Context context) {
        super(context);
    }

    /**
     * Get the Bank entity with the given id.
     *
     * @return A Bank entity or null if the id is null or the DataBase can not be accessed.
     */
    public Bank getById(Long id) {
        if (id == null) {
            return null;
        }

        if (db != null) {
            Bank bank = null;
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            BankDao bankDao = daoSession.getBankDao();
            bank = bankDao.load(id);
            daoSession.clear();
            daoMaster = null;
            return bank;
        }

        return null;
    }

}
