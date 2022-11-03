package com.metaxiii.fr.feigntransfert.service.client;

import com.metaxiii.fr.feigntransfert.service.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fake-feign", url = "http://localhost:8081", configuration = FeignConfig.class)
public interface FakeClient {
    @GetMapping("")
    ResponseEntity<String> getHello();

    @GetMapping("{id}")
    ResponseEntity<String> getError(@PathVariable(name = "id") String id);
}
