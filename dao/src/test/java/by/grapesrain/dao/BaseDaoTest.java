package by.grapesrain.dao;

import by.grapesrain.config.TestConfigDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by PloSkiY on 03.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigDB.class)
@Transactional
public abstract class BaseDaoTest {

}
