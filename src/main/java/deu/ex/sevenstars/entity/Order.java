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
@Table(name="tbl_order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String email;

    private String address;

    private String postcode;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public void changeAddress(String address) {
        this.address = address;
    }

    public void changePostcode(String postcode) {
        this.postcode = postcode;
    }

    public void changeOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
