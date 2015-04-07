package com;

import com.db.*;
import com.resources.*;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class ApplicationMain extends Application<ApplicationMainConfiguration> {

    public static void main(String[] args) throws Exception {
        System.out.println(args.toString());
        new ApplicationMain().run(args);
    }

    @Override
    public void initialize(Bootstrap<ApplicationMainConfiguration> bootstrap) {
        // nothing to do yet
        bootstrap.addBundle(new MigrationsBundle<ApplicationMainConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(ApplicationMainConfiguration configuration) {
                return configuration.getDatabase();
            }
        });
    }

    @Override
    public void run(ApplicationMainConfiguration configuration, Environment environment) throws Exception {

        //DAO connectors
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabase(), configuration.getDatabaseName());

        //DAO layer
        final SimpleTransactionManager simpleTransactionManager = new SimpleTransactionManager(jdbi);
        final MyDAO myDAO = jdbi.onDemand(MyDAO.class);

        //Business layer

        //Resources
        final ApplicationResource applicationResource = new ApplicationResource(myDAO);

        //Register resources
        environment.jersey().register(applicationResource);
    }
}
