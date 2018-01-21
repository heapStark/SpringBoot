package heapstark.controller;

import heapstark.dao.mapper.PropertyConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
@RestController
public class ConfigController {
    @Autowired
    HashMap<String, String> propertyConfigs;
    @Autowired
    PropertyConfigMapper propertyConfigMapper;

    @RequestMapping("/config")

    public HashMap<String, String> config() {

        return propertyConfigs;
    }

    @RequestMapping("/config2")

    public HashMap<String, String> config2() {

        HashMap hashMap = propertyConfigMapper.findPropertyMap(new HashMap());
        return hashMap;
    }
}
