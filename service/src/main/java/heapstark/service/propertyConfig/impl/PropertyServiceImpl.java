package heapstark.service.propertyConfig.impl;

import heapstark.dao.mapper.PropertyConfigMapper;
import heapstark.service.propertyConfig.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyConfigMapper propertyConfigMapper;

    @Cacheable
    public List<HashMap<String, String>> findProperty() {
        return propertyConfigMapper.findProperty();
    }
}
