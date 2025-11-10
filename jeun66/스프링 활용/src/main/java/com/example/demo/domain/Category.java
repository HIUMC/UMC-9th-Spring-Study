package jpabook.jpashop.domain;
import lombok.Getter;
import lombok.Setter;
import jpabook.jpashop.domain.item.Item;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
ackage jpabook.jpashop.domain;
import lombok.Getter;
import jakarta.persistence.Embeddable;
@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;
    protected Address() {
    }
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
