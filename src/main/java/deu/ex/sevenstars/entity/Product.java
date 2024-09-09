package deu.ex.sevenstars.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="tbl_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    @Enumerated(EnumType.STRING)
    private Category category;

    private long price;

    private String description;


    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems = new ArrayList<>();


    public void changeDescription(String description) {
        this.description = description;
    }

    public void changeProductName(String productName) {
        this.productName = productName;
    }

    public void changeCategory(Category category) {
        this.category = category;
    }

    public void changePrice(long price) {
        this.price = price;
    }
}
