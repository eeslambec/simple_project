package uz.tiue.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.tiue.project.dto.ProductCRUDDto;
import uz.tiue.project.exception.AlreadyExistException;
import uz.tiue.project.exception.NotFoundException;
import uz.tiue.project.exception.NullOrEmptyException;
import uz.tiue.project.model.Product;
import uz.tiue.project.repository.ProductRepository;
import uz.tiue.project.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(ProductCRUDDto product) {
        if (product == null) {
            throw new NullOrEmptyException("product");
        }
        if (productRepository.findByName(product.getName()).isPresent()) {
            throw new AlreadyExistException("product");
        }
        return productRepository.save(Product.builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .build());
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NullOrEmptyException("product"));
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name).orElseThrow(() -> new NullOrEmptyException("product"));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        if (productRepository.findById(id).isEmpty()){
            throw new NotFoundException("product");
        }
        productRepository.deleteById(id);
        return "salom";
    }
}
