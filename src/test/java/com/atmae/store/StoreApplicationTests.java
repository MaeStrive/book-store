package com.atmae.store;


import com.atmae.store.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired
    private DataSource druidDataSource;
    @Autowired
    private IUserService userService;

    @Test
    void getConnection() throws SQLException {
        System.out.println(druidDataSource.getConnection());
    }

    @Test
    void contextLoads() {
    }


}
