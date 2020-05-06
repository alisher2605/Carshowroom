package kz.iitu.carshowroom.Repositories;

import kz.iitu.carshowroom.Entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    List<Manufacturer>findManufacturerByName(String name);
}
