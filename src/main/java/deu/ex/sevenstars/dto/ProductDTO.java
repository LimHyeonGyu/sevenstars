package deu.ex.sevenstars.dto;

import deu.ex.sevenstars.entity.Category;
import deu.ex.sevenstars.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private Category category;
    private long price;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }

    public Product toEntity(){
        return Product.builder()
                .productId(productId)
                .productName(productName)
                .category(category)
                .price(price)
                .description(description)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
