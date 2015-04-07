package com.db;


public interface TransactionManager {

    public Object getTransactionScope(ApplicationTransaction transaction, Class... daos);
}

