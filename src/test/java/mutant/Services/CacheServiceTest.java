package mutant.Services;


import mutant.Data.Repository.DNARepository;
import mutant.Utils.Helpers.CommonHelper;
import mutant.Utils.Static.Constants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

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

            cache.put( new String("1"), new String("1") );
            Thread.sleep(1);
            cache.put( new String("2"), new String("2") );
            Thread.sleep(1);
            cache.put( new String("3"), new String("3") );
            Thread.sleep(1);
            cache.put( new String("4"), new String("4") );
            cache.put( new String("5"), new String("5") );
            cache.put( new String("6"), new String("6") );
            cache.put( new String("7"), new String("7") );
            cache.put( new String("8"), new String("8") );
            cache.put( new String("9"), new String("9") );
            cache.put( new String("10"), new String("10") );

            Assert.assertEquals("Cache should be full.",SIZE, cache.getSize());

            cache.put( new String("11"), new String("11") );
            Assert.assertEquals("Cache should still be full.",SIZE, cache.getSize());

            Object result = cache.get( new String("11") );
            Assert.assertNotNull("11 should be in the cache.", result);
            result = cache.get( new String("1") );
            Assert.assertNull("1 should no longer be in the cache.", result);

            result = cache.get( new String("2") );
            Assert.assertNotNull("2 should still be in the cache.", result);

            cache.put( new String("12"), new String("12") );
            Assert.assertEquals("Cache should still be full.",SIZE, cache.getSize());
    }

    @After
        public void tearDown(){
            cache.destroy();
        }


}
