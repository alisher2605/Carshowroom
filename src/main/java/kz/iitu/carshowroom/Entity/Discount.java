package kz.iitu.carshowroom.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@ToString
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long discountId;

    private int discountSize;
    private String discountDescription;
}
