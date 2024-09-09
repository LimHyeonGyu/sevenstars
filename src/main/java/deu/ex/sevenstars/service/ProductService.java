package deu.ex.sevenstars.service;

import deu.ex.sevenstars.dto.ProductDTO;
import deu.ex.sevenstars.entity.Product;
import deu.ex.sevenstars.exception.ProductException;
import deu.ex.sevenstars.exception.ProductTaskException;
import deu.ex.sevenstars.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class ProductService {
    private final ProductRepository productRepository;

    //상품 조회
    public ProductDTO read(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(ProductException.NOT_FOUND::get);
        return new ProductDTO(product);
    }

    //상품 목록 조회
    public List<ProductDTO> readAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    //상품 추가
    public ProductDTO register(ProductDTO productDTO) {
        try {
            Product product = productDTO.toEntity();
            productRepository.save(product);
            return new ProductDTO(product);
        } catch (Exception e) {
            throw ProductException.NOT_REGISTERED.get();
        }
    }

    //상품 수정
    public ProductDTO modify(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getProductId())
                .orElseThrow(ProductException.NOT_FOUND::get);

        try {
            product.changeProductName(productDTO.getProductName());
            product.changeDescription(productDTO.getDescription());
            product.changePrice(productDTO.getPrice());
            product.changeCategory(productDTO.getCategory());
            return new ProductDTO(product);
        } catch(Exception e) {
            log.error("--- " + e.getMessage());
            throw ProductException.NOT_MODIFIED.get();
        }
    }

    //상품 삭제
    public void remove(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(ProductException.NOT_FOUND::get);

        try {
            productRepository.delete(product);
        } catch(Exception e) {
            log.error("--- " + e.getMessage());
            throw ProductException.NOT_REMOVED.get();
        }
    }


}
