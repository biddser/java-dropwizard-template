package com.db;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SimpleTransactionManager implements TransactionManager {


    private DBI dbi;

    public SimpleTransactionManager(DBI dbi) {
        this.dbi = dbi;
    }


    public Object getTransactionScope(
            ApplicationTransaction transaction, Class... daos) {
        Handle h = dbi.open();

        List<BaseDAO> attachedDAOs = new ArrayList<>();
        for (Class<BaseDAO> dao : daos) {
            attachedDAOs.add(h.attach(dao));
        }
        try {
            h.getConnection().setAutoCommit(false);
            return transaction.execute(h, attachedDAOs.toArray(new BaseDAO[0]));
        } catch (SQLException e) {
            e.printStackTrace();
            h.rollback();
            return null;
        } finally {
            try {
                h.getConnection().setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            h.close();
        }
    }


}