package deu.ex.sevenstars.repository;

import deu.ex.sevenstars.entity.Category;
import deu.ex.sevenstars.entity.Product;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@Log4j2
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test   //기본 상품 데이터 추가
    public void testInsert() {
        Product product = Product.builder()
                .productName("Columbia Coffee")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .price(10000L)
                .description("콜롬비아의 맛있는 커피")
                .build();
        Product savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);

        product = Product.builder()
                .productName("Columbia Quindio")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .price(20000L)
                .description("콜롬비아의 Quindio 커피")
                .build();
        savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);

        product = Product.builder()
                .productName("Brazil Serra Do Coffee")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .price(15000L)
                .description("브라질산 풍미가득한 커피")
                .build();
        savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);

        product = Product.builder()
                .productName("Ethiopia Sidamo")
                .category(Category.COFFEE_BEAN_PACKAGE)
                .price(8000L)
                .description("에디오피아 커피 빈")
                .build();
        savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);

    }
}
