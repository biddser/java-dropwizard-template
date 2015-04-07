package com.db;

import com.mapper.*;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(MyMapper.class)
public interface MyDAO extends BaseDAO {

    @SqlQuery("SELECT COUNT(*) FROM mytable WHERE id = :id")
    Integer countItems(@Bind("id") Long id);

    @SqlUpdate("DELETE FROM mytable WHERE id = :id ")
    void remove(@Bind("id") Long id);
}
