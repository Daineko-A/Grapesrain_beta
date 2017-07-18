package by.grapesrain.services;

import by.grapesrain.config.TestConfigServices;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by Alexandr on 18.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfigServices.class)
@TestPropertySource(locations = "classpath:database.properties")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public abstract class BaseServiceTest {
}
