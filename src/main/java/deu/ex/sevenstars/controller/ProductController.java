package deu.ex.sevenstars.controller;

import deu.ex.sevenstars.dto.ProductDTO;
import deu.ex.sevenstars.exception.ProductException;
import deu.ex.sevenstars.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seven/product")
@Log4j2
public class ProductController {
    private final ProductService productService;

    //상품 조회
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> read(@PathVariable("productId") Long productId) {
        log.info("--- read()");
        return ResponseEntity.ok(productService.read(productId));
    }

    //상품 조회(리스트)
    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> readAll() {
        log.info("--- readAll()");
        return ResponseEntity.ok(productService.readAll());
    }

    //상품 추가
    @PostMapping
    public ResponseEntity<ProductDTO> register(@Validated @RequestBody ProductDTO productDTO) {
        log.info("--- register()");
        return ResponseEntity.ok(productService.register(productDTO));
    }

    //상품 수정
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> modify(@Validated @RequestBody ProductDTO productDTO,
                                             @PathVariable("productId") Long productId) {
        log.info("--- modify()");

        if(!productId.equals(productDTO.getProductId())) {
            throw ProductException.NOT_MATCHED.get();
        }

        return ResponseEntity.ok(productService.modify(productDTO));
    }

    //상품 삭제
    @DeleteMapping("/{productId}")
    public ResponseEntity<Map<String, String>> remove(@PathVariable("productId") Long productId) {
        log.info("--- remove()");
        productService.remove(productId);
        return ResponseEntity.ok(Map.of("result", "success"));
    }

}
