package shafin.temp.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shafin
 * @since 2/15/18
 */
@RestController
public class ApiController {

    @GetMapping("/rest")
    public String getTest() {
        return "hello";
    }
}
