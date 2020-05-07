package kz.iitu.carshowroom.Controllers;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Returns list of all vehicles")
    @GetMapping("")
    public List<Vehicle>vehicleList(){
        return vehicleRepository.findAll();
    }

    @ApiOperation(value = "Returns vehicle with entered id")
    @GetMapping("/{id}")
    public Vehicle vehicleListById(@PathVariable("id") long id){
        return vehicleRepository.findById(id).get();
    }

    @ApiOperation(value = "Returns all available vehicles (>0)")
    @GetMapping("/available")
    public List<Vehicle> availableVehicles(){
        return vehicleRepository.findAvailableVehicle();
    }

    @ApiOperation(value = "Returns vehicle with entered model")
    // /vehicle/find/?name=AMG
    @GetMapping("/find/")
    public void findVehicleByModel(@RequestParam(name = "name")String name){
        vehicleRepository.findVehicleByModel(name);
    }

    @ApiOperation(value = "Creates new vehicle")
    @PostMapping("/create")
    public Vehicle newVehicle(@RequestBody Vehicle vehicle){
        return vehicleRepository.saveAndFlush(vehicle);
    }

    @ApiOperation(value = "Updates vehicle with entered id")
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
