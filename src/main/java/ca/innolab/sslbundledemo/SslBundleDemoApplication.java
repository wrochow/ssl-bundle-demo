package ca.innolab.sslbundledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SslBundleDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslBundleDemoApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
