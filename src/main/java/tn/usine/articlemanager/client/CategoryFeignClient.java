package tn.usine.articlemanager.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.usine.articlemanager.service.dto.CategoryDTO;

@FeignClient(name = "localhost:8082")
@Headers({ "Accept: application/json", "Content-Type: application/json" })
public interface CategoryFeignClient {
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") String id);
}
