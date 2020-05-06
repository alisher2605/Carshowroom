package kz.iitu.carshowroom.Repositories;

import kz.iitu.carshowroom.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("select v from Vehicle v where v.quantity>0")
    List<Vehicle> findAvailableVehicle();

      void findVehicleByModel(String modelName);
}
