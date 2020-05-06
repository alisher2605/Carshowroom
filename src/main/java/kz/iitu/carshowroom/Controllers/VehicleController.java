package kz.iitu.carshowroom.Controllers;

import kz.iitu.carshowroom.Entity.Manufacturer;
import kz.iitu.carshowroom.Entity.Vehicle;
import kz.iitu.carshowroom.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("")
    public List<Vehicle>vehicleList(){
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle vehicleListById(@PathVariable("id") long id){
        return vehicleRepository.findById(id).get();
    }

    @GetMapping("/available")
    public List<Vehicle> availableVehicles(){
        return vehicleRepository.findAvailableVehicle();
    }

    // /vehicle/find/?name=AMG
    @GetMapping("/find/")
    public void findVehicleByModel(@RequestParam(name = "name")String name){
        vehicleRepository.findVehicleByModel(name);
    }

    @PostMapping("")
    public Vehicle newVehicle(@RequestBody Vehicle vehicle){
        return vehicleRepository.saveAndFlush(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable long id, @RequestBody Vehicle vehicle){
        vehicle.setVehicleId(id);
        return vehicleRepository.saveAndFlush(vehicle);
    }


    @DeleteMapping("/{id}")
    public Vehicle removeVehicle(@PathVariable("id") long id){
        Vehicle vehicle = this.vehicleListById(id);
        vehicleRepository.delete(vehicle);
        return vehicle;
    }
}
