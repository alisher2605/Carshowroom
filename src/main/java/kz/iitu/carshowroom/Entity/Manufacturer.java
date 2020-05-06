package kz.iitu.carshowroom.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter

public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long manufacturerId;
    private String name;
    private String description;
    private String country;

    @JsonIgnore
    @ManyToMany(mappedBy = "manufacturers",  fetch = FetchType.LAZY)
    private List<Vehicle> vehicleList;


}
