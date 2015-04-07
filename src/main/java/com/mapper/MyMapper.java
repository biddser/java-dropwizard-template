package com.mapper;

import com.pojo.MyEntity;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyMapper implements ResultSetMapper<MyEntity> {

    @Override
    public MyEntity map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        MyEntity entity = new MyEntity(
                resultSet.getString("value")
        );

        return entity;
    }
}
