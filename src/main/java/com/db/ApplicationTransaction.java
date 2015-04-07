package com.db;

import org.skife.jdbi.v2.Handle;

import java.sql.SQLException;

public interface ApplicationTransaction<T> {
    T execute(Handle h, BaseDAO... daos) throws SQLException;
}
