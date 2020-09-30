package com.xcl.config;

import com.google.common.cache.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Configuration
public class GuavaConfig {

    @Bean
    Cache<String,Object> loadingCache() throws ExecutionException {
        Cache<String,Object> cache = CacheBuilder.newBuilder()
                    //3秒过期
                    .expireAfterAccess(3, TimeUnit.SECONDS)
                    .recordStats()
                    .build();
        return cache;
    }

    private void initCache(LoadingCache<String, Object> cache) throws ExecutionException {
        for(int i=1;i<=6;i++){
            cache.get(String.valueOf(i));
        }
    }

}
