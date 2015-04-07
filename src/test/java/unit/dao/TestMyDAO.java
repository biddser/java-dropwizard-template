package unit.dao;

import com.db.MyDAO;
import org.skife.jdbi.v2.sqlobject.Bind;


public class TestMyDAO implements MyDAO {
    @Override
    public Integer countItems(@Bind("id") Long id) {
        return 3;
    }

    @Override
    public void remove(@Bind("id") Long id) {

    }
}
