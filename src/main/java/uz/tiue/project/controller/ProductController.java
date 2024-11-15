package uz.tiue.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tiue.project.dto.ProductCRUDDto;
import uz.tiue.project.model.Product;
import uz.tiue.project.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductCRUDDto productCRUDDto) {
        return ResponseEntity.ok(productService.save(productCRUDDto));
    }
    @GetMapping("/get/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }
    @GetMapping("/get/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }
    @GetMapping("/get/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getByName(name));
    }
    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteById(id));
    }
}
