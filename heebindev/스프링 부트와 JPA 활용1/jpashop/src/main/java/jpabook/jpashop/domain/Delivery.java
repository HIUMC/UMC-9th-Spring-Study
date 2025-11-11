package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY) //연관 관계 거울
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //디폴트인 ordinal은 쓰면 안된다. 숫자로 들어간다.
    private DeliveryStatus status; //Ready, COMP

}