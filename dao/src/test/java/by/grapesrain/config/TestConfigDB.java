package by.grapesrain.config;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by PloSkiY on 30.06.2017.
 */
@Configuration
@Import(ConfigDB.class)
public class TestConfigDB {

    @Value("${jdbc.url}")
    private String dbUrl;

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public JdbcDataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
