package kz.iitu.carshowroom.Repositories;

import kz.iitu.carshowroom.Controllers.VehicleTypeController;
import kz.iitu.carshowroom.Entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    void findVehicleTypeByType(String type);
}
