package com.artbyte.eureka_client_b;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ServiceBController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public ServiceBController(DiscoveryClient discoveryClient, RestClient restClient) {
        this.discoveryClient = discoveryClient;
        this.restClient = restClient;
    }

    @GetMapping("/helloEureka")
    public String saludoServiceB(){
        ServiceInstance serviceInstance = discoveryClient.getInstances("service-a").get(0);
        String serviceResponse = restClient.get()
                .uri(serviceInstance.getUri() + "/serviceA")
                .retrieve()
                .body(String.class);
        return serviceResponse;
    }
}
