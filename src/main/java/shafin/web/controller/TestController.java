package shafin.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shafin
 * @since 11/9/17
 */
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String testMethod() {
        return "Hello from test";
    }

    @GetMapping(name = "/test/{count}")
    public String testMethod(@PathVariable(value = "count") Integer count) {
        return "Hello from Parameterized Test. Count: " + count;
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam String[] keywords){
        System.out.println(keywords);
        return "home";
    }
}
