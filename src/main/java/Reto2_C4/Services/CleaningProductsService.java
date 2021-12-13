/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_C4.Services;

import Reto2_C4.Repository.CleaningProductsRepository;
import Reto2_C4.Model.CleaningProducts;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabrielroa
 */
@Service
public class CleaningProductsService {
    
    @Autowired
    private CleaningProductsRepository repository;
    
    //@Autowired
    //private MongoTemplate mongoTemplate;

    public List<CleaningProducts> getAll() {
        return repository.getAll();
    }

   public Optional<CleaningProducts> getCleaningProduct(String reference) {
        return repository.getProduct(reference);
    }

    public CleaningProducts create(CleaningProducts product) {
        if (product.getReference() == null) {
            return product;
        } else {
            return repository.create(product);
        }
    }
    public CleaningProducts update(CleaningProducts product) {

        if (product.getReference() != null) {
            Optional<CleaningProducts> productDb = repository.getProduct(product.getReference());
            if (!productDb.isEmpty()) {
                
                if (product.getBrand()!= null) {
                    productDb.get().setBrand(product.getBrand());
                }
                
                if (product.getCategory() != null) {
                    productDb.get().setCategory(product.getCategory());
                }
                
                if (product.getDescription() != null) {
                    productDb.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    productDb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    productDb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    productDb.get().setPhotography(product.getPhotography());
                }
                productDb.get().setAvailability(product.isAvailability());
                repository.update(productDb.get());
                return productDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }
     public boolean delete(String reference) {
        Boolean aBoolean = getCleaningProduct(reference).map(product -> {
            repository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //Reto 5
    public List<CleaningProducts> productByPrice(double price) {
        return repository.productByPrice(price);
    }

    //Reto 5
    public List<CleaningProducts> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
    
}
