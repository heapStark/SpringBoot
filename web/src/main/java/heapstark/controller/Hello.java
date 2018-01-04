package heapstark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WZL on 2018/1/4.
 */
@RestController
public class Hello {
    @RequestMapping("/")
    public String hello (){
        return "hello";
    }
}
