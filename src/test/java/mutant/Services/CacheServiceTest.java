package mutant.Services;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Class responsible for test cache service methods.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CacheServiceTest {
    private static final int SIZE = 10;

    @Autowired
    private CacheService cache;


    @Before
    public void setUp(){
        cache.clearAll();
    }


    @Test
    public void testLRU() throws Exception {
            Assert.assertEquals("Cache should be empty.",0, cache.getSize());

            cache.put("1", "1");
            Thread.sleep(1);
            cache.put("2", "2");
            Thread.sleep(1);
            cache.put("3", "3");
            Thread.sleep(1);
            cache.put("4", "4");
            cache.put("5", "5");
            cache.put("6", "6");
            cache.put("7", "7");
            cache.put("8", "8");
            cache.put("9", "9");
            cache.put("10", "10");

            Assert.assertEquals("Cache should be full.",SIZE, cache.getSize());

            cache.put("11", "11");
            Assert.assertEquals("Cache should still be full.",SIZE, cache.getSize());

            Object result = cache.get("11");
            Assert.assertNotNull("11 should be in the cache.", result);
            result = cache.get("1");
            Assert.assertNull("1 should no longer be in the cache.", result);

            result = cache.get("2");
            Assert.assertNotNull("2 should still be in the cache.", result);

            cache.put("12", "12");
            Assert.assertEquals("Cache should still be full.",SIZE, cache.getSize());
    }

    @After
        public void tearDown(){
            cache.destroy();
        }


}
