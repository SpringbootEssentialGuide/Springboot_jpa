package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

//https://ocblog.tistory.com/44 - 스프링부트 / Bean 이해하기
//ProductDAOImpl 클래스를 스프링이 관리하는 빈으로 등록하려면 3번 줄과 같이 @Component 또는 @Service 어노테이션을 지정해야 합니다.
//빈으로 등록된 객체는 다른 클래스가 인터페이스를 가지고 의존성을 주입받을 때 이 구현체를 찾아 주입하게 됩니다.
@Component
public class ProductDAOImpl implements ProductDAO {

//    마찬가지로 DAO객체에서도 데이터베이스에 접근하기 위해 리포지토리 인터페이스를 사용해 의존성 주입을 받아야 합니다.
//    아래 줄과 같이 리포지토리를 정의하고, 생성자를 통해 의존성 주입을 받으면 됩니다.
    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getById(number);

        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        }
        else {
            throw new Exception();
        }

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            productRepository.delete(product);
        }
        else {
            throw new Exception();
        }
    }


}
