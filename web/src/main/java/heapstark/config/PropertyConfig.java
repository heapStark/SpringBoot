package heapstark.config;

import heapstark.dao.plugin.MapIntercept;
import heapstark.service.propertyConfig.PropertyService;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
@Configuration
public class PropertyConfig {
    @Autowired
    PropertyService propertyService;

    @Bean(name = "propertyConfigs")
    public HashMap<String, String> createPropertyConfig() {
        List<HashMap<String, String>> list = propertyService.findProperty();
        HashMap hashMap = new HashMap();
        list.forEach((map) -> {
            hashMap.put(map.get("propkey"), map.get("propvalue"));
        });
        return hashMap;
    }
    @Bean
    public Interceptor getInterceptor(){
        return new MapIntercept();
    }
}
