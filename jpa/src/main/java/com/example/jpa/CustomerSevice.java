package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerSevice {
    private final DataSource dataSource = new EmbeddedDatabaseBuilder()
            .setName("customer").setType(EmbeddedDatabaseType.H2).build();



    public static void main(String[] args) {
        CustomerSevice customerSevice = new CustomerSevice();

        DataSource dataSource = customerSevice.dataSource;

        DataSourceInitializer init = new DataSourceInitializer();

        init.setDataSource(dataSource);

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();

        populator.setScripts(new ClassPathResource("schema.sql"), new ClassPathResource("data.sql"));

        init.setDatabasePopulator(populator);
        init.afterPropertiesSet();

        int size = customerSevice.findAll().size();

        Assert.isTrue(size == 2);
//        SpringApplication.run(CustomerSevice.class);

    }


    public Collection<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();

        try {
            Connection c = dataSource.getConnection();
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("select * from CUSTOMERS");
            while (rs.next()) {
                customerList.add(new Customer(rs.getLong("ID"), rs.getString("Email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

}
