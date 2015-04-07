package com.resources;

import com.db.MyDAO;
import com.pojo.MyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


public class ApplicationResource {

    private static final Logger log = LoggerFactory.getLogger(ApplicationResource.class);
    private final MyDAO myDAO;

    public ApplicationResource(MyDAO myDAO) {
        this.myDAO = myDAO;
    }

    @GET
    @Path("/helloworld/")
    public String get() {
        return "Hello World";
    }

    @GET
    @Path("/helloworld/{name}")
    public MyEntity get(@PathParam("name") String name) {
        return new MyEntity("Hello " + name);
    }


}
