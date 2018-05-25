package com.forezps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceWoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceWoApplication.class, args);
    }

    @Value("${server.port}")
    String port;
    @Value("${eureka.client.serviceUrl.defaultZone}")
    String resourceUrl;

    @RequestMapping("/wo")
    public String home(@RequestParam String name) {
        return "wo " + name + ",i am from port:" + port + "resourUrl" + resourceUrl;
    }
}
