package qrcode.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    
    @RequestMapping({"/hello", "/"})
    public String ping() {
        return "Hello, the service is running";
    }


    @RequestMapping("/version")
    public String version() {
        return "1.0";
    }
}
