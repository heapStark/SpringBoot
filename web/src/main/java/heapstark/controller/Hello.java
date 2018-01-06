package heapstark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by WZL on 2018/1/4.
 */
@RestController
public class Hello {
    @RequestMapping("/{hello}")
    public String hello (HttpServletRequest request){

        return "hello";
    }
}
