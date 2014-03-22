package com.exchange.data;

import android.content.Context;

import com.exchange.dao.Bank;
import com.exchange.dao.BankDao;
import com.exchange.dao.DaoMaster;
import com.exchange.dao.DaoSession;
import com.exchange.exceptions.WrongIdException;

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
    public Bank getById(Long id) throws WrongIdException {
        if (id == null) {
            throw new WrongIdException();
        }

        if (db != null) {
            Bank bank = null;
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            BankDao bankDao = daoSession.getBankDao();
            bank = bankDao.load(id);
            daoSession.clear();
            daoMaster = null;

            if (bank == null) {
                throw new WrongIdException();
            }
            return bank;
        }

        return null;
    }

    /**
     * Insert a Bank entity into DataBase.
     *
     * @param bank the Bank entity to insert.
     * @return the id of the inserted entity or -1 if a problem occurred.
     */
    public Long insert(Bank bank) {
        if (bank == null) {
            return -1L;
        }

        if (db != null) {
            DaoMaster daoMaster = new DaoMaster(db);
            DaoSession daoSession = daoMaster.newSession();
            BankDao bankDao = daoSession.getBankDao();
            Long id = bankDao.insert(bank);
            daoSession.clear();
            daoMaster = null;
            return id;
        }

        return -1L;
    }

}
