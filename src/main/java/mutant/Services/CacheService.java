package mutant.Services;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private static final String DEFAULTNAME="dnas";

    @Autowired
    private CacheManager cacheManager;

    private final String cacheName;

    public CacheService(){
        this.cacheName = DEFAULTNAME;
    }

    public int getSize(){
        Cache cache =cacheManager.getCache(cacheName);
        return cache.getSize();
    }

    public void put(Object key, Object value){
        Cache cache =cacheManager.getCache(cacheName);
        cache.putIfAbsent(new Element(key,value));
    }

    public Object get(Object key){
        Cache cache =cacheManager.getCache(cacheName);
        Element element = cache.get(key);
        if(element !=null)
            return element.getObjectValue();
        return null;
    }
    public void clearAll(){
        Cache cache =cacheManager.getCache(cacheName);
        cache.removeAll();
    }

    public void destroy(){
        Cache cache =cacheManager.getCache(cacheName);
        cache.removeAll();
        cache.dispose();
        cacheManager.shutdown();
    }
}
