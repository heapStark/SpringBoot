package heapstark.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/6.
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicUrlController {
    //localhost:8080/dynamic/id/123:hello
    @RequestMapping("/id/{id}")
    public String id(
            @PathVariable("id") String id ) {
        return id;
    }
    //localhost:8080/dynamic/number/123:hello
    @RequestMapping("/number/{number}:hello")
    public int number(
            @PathVariable("number") int number ) {
        return number;
    }
    //localhost:8080/dynamic/number/123:hello/t
    @RequestMapping("/number/{number}:hello/t")
    public int anInt(
            @PathVariable("number") int number ) {
        return number;
    }
    //localhost:8080/dynamic/number/qwerwww333/t
    @RequestMapping("/number/{number:[a-z-]+}{other:\\d{3}}/t")
    public String regular(
            @PathVariable("number") String number ,
            @PathVariable("other")String other) {
        return number+other;
    }
    //不支持
/*    @RequestMapping("/date/{date}")
    public Date date(
            @PathVariable("date") Date date ) {
        return date;
    }*/
}
