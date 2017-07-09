package by.grapesrain.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;


/**
 * Created by PloSkiY on 29.06.2017.
 */
@Configuration
@ComponentScan(basePackages = {"by.grapesrain.dao", "by.grapesrain.entitys", "by.grapesrain.dao.common"})
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class ConfigDB {

    @Value("${jdbc.url}")
    private String dbUrl;

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.format_sql}")
    private String formatSql;

    @Value("${hibernate.creation_policy}")
    private String creationPolicy;


    @Value("${hibernate.cache.use_second_level_cache}")
    private String useSecLevCache;

    @Value("${hibernate.cache.use_query_cache}")
    private String useQueryCache;

    @Value("${hibernate.cache.region.factory_class}")
    private String cacheRegion;

    @Value("${net.sf.ehcache.configurationResourceName}")
    private String ehcacheConf;

    @Value("${hibernate.generate_statistics}")
    private String statistics;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("by.grapesrain.entitys");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());

        return sessionFactoryBean;
    }

    @Bean
    public Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.format_sql", formatSql);
        properties.setProperty("hibernate.hbm2ddl.auto", creationPolicy);

        properties.setProperty("hibernate.cache.use_second_level_cache", useSecLevCache);
        properties.setProperty("hibernate.cache.use_query_cache", useQueryCache);
        properties.setProperty("hibernate.cache.region.factory_class", cacheRegion);
        properties.setProperty("net.sf.ehcache.configurationResourceName", ehcacheConf);
        properties.setProperty("hibernate.generate_statistics", statistics);

        //TODO: connection isolation
//        properties.setProperty("hibernate.connection.isolation", String.valueOf(Connection.TRANSACTION_REPEATABLE_READ));
        return properties;
    }


    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
