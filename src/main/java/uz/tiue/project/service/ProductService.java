package uz.tiue.project.service;

import org.springframework.stereotype.Service;
import uz.tiue.project.dto.ProductCRUDDto;
import uz.tiue.project.model.Product;

import java.util.List;

@Service
public interface ProductService {
    Product save(ProductCRUDDto product);
    Product getById(Long id);
    Product getByName(String name);
    List<Product> getAll();
    String deleteById(Long id);
}
