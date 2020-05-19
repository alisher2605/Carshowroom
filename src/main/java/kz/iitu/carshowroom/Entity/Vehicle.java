package kz.iitu.carshowroom.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicleId;
    private String model;
    private Date productionYear;
    private String transmissionType;
    private String state;
    private String color;
    private int quantity;
    private String vehicleSet;
    private double price;



    @JsonIgnore
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<VehicleType>vehicleTypes;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "VehicleManufacturer",
            joinColumns = {@JoinColumn(name = "vehicleId", referencedColumnName = "vehicleId")},
            inverseJoinColumns = {@JoinColumn(name="manufacturerId", referencedColumnName = "manufacturerId")}
    )
    private List<Manufacturer> manufacturers;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "CarShowroom",
            joinColumns = {@JoinColumn(name = "vehicleId", referencedColumnName = "vehicleId")},
            inverseJoinColumns = {@JoinColumn(name="clientId", referencedColumnName = "clientId")}
    )

    private List<Client> clients;

}
