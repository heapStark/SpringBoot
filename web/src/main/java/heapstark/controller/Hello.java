package heapstark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by WZL on 2018/1/4.
 */
@RestController
public class Hello {
    @RequestMapping("/hello/{hello}")
    public String hello (HttpServletRequest request){

        return "hello";
    }
    @RequestMapping(value = "/time",method = RequestMethod.GET)
    public Date time(@RequestParam String name){
        return new Date();
    }
}
