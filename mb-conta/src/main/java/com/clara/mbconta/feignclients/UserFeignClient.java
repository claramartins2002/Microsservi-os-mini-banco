package com.clara.mbconta.feignclients;

import com.clara.mbconta.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "mb-user",url = "localhost:8081", path = "/user")
public interface UserFeignClient {
    @GetMapping(value = "/{cpf}")
    public ResponseEntity<User> buscaPorCpf(@PathVariable String cpf);
}
