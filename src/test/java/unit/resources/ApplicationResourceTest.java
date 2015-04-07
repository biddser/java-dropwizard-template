package unit.resources;

import com.db.MyDAO;
import com.pojo.MyEntity;
import com.resources.ApplicationResource;
import org.junit.Before;
import org.junit.Test;
import unit.dao.TestMyDAO;

import static org.junit.Assert.assertEquals;

public class ApplicationResourceTest {

    private final MyDAO myDAO = new TestMyDAO();
    private final ApplicationResource resource = new ApplicationResource(myDAO);

    @Before
    public void setup() {

    }

    @Test
    public void test_canGetHello_ok() {
        //given
        String name = "User";

        //when
        MyEntity response = resource.get(name);

        //then
        assertEquals("Hello " + name, response.getValue());
    }

    @Test
    public void test_canGetHelloWorld_ok() {
        //given

        //when
        String response = resource.get();

        //then
        assertEquals("Hello World", response);
    }
}
