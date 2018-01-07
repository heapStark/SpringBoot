package heapstark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * springBoot
 * Created by wangzhilei3 on 2018/1/7.
 */
@Controller
public class Redirect {
    @RequestMapping(value = "/swagger", method = RequestMethod.GET)
    public String time() {
        return "redirect:swagger-ui.html";
    }
}
