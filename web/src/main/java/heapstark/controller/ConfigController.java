package heapstark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/20.
 */
@RestController
public class ConfigController {
    @Autowired
    HashMap<String, String> propertyConfigs;

    @RequestMapping("/config")

    public HashMap<String, String> config() {

        return propertyConfigs;
    }
}
