package com.t1.project.core.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Aspect
@Component
public class CachedAspect {

    @Value("${cache.ttl-ms}")
    private long ttl;
    private final Map<String, CacheEntry> caches = new ConcurrentHashMap<>();

    @Around("@annotation(com.t1.project.core.aspect.annotation.Cached)")
    public Object cacheResult(ProceedingJoinPoint pJoinPoint) throws Throwable {
        String key = pJoinPoint.getSignature().toShortString() +
                Arrays.deepHashCode(pJoinPoint.getArgs());
        CacheEntry entry = caches.get(key);
        if (entry != null && !entry.isExpired()) {
            log.info("CACHE: Get {} from caches!", pJoinPoint.getSignature().toShortString());
            return entry.getObject();
        }
        Object result = pJoinPoint.proceed();
        caches.put(key, new CacheEntry(result, System.currentTimeMillis()));
        log.info("CACHE: Put {} to caches!", pJoinPoint.getSignature().toShortString());
        return result;
    }

    @Scheduled(fixedRate = 60_000)
    public void clearingExpired() {
        caches.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }


    private class CacheEntry {

        private final Object object;
        private final long createTime;

        CacheEntry(Object object, long createTime) {
            this.object = object;
            this.createTime = createTime;
        }

        Object getObject() {
            return object;
        }

        boolean isExpired() {
            return (System.currentTimeMillis() - createTime) > ttl;
        }
    }
}
