package deu.ex.sevenstars.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="tbl_order_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private long price;

    private long quantity;

    public void changePrice(Long price) { this.price = price; }
    public void changeQuantity(long quantity) { this.quantity = quantity; }
}
