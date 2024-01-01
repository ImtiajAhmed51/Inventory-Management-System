package imtiaj.service;

import imtiaj.model.Product;
import imtiaj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public void create(Product product) {
        productRepository.create(product);
    }

    public Product find(int id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.getAll();
    }

    public void updateProduct(Product product) {
        productRepository.edit(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product.getProductId());
    }


}
