package ulas.eurekaclientspring;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ServerDiscoveryController {

    private final DiscoveryClient client;

    @GetMapping("/apps/{appName}")
    public ResponseEntity<List<ServiceInstance>> getApps(@PathVariable String appName){
        return ResponseEntity.ok(client.getInstances(appName));
    }


}
