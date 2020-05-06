package kz.iitu.carshowroom.Controllers;

import kz.iitu.carshowroom.Entity.Vehicle;
import kz.iitu.carshowroom.Entity.VehicleType;
import kz.iitu.carshowroom.Repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiclestypes")
public class VehicleTypeController {
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    @GetMapping("")
    public List<VehicleType> vehicleTypeList(){
        return vehicleTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public VehicleType vehicleTypeListById(@PathVariable("id") long id){
        return vehicleTypeRepository.findById(id).get();
    }

    // /vehicle/find/?type=universal
    @GetMapping("/find/")
    public void indVehicleByModel(@RequestParam(name = "type")String type){
        vehicleTypeRepository.findVehicleTypeByType(type);
    }

    @PostMapping("")
    public VehicleType newVehicleType(@RequestBody VehicleType vehicleType){
        return vehicleTypeRepository.saveAndFlush(vehicleType);
    }

    @PutMapping("/{id}")
    public VehicleType updateVehicleType(@PathVariable long id, @RequestBody VehicleType vehicleType){
        vehicleType.setTypeId(id);
        return vehicleTypeRepository.saveAndFlush(vehicleType);
    }

    @DeleteMapping("/{id}")
    public VehicleType removeBook(@PathVariable("id") long id){
        VehicleType vehicleType = this.vehicleTypeListById(id);
        vehicleTypeRepository.delete(vehicleType);
        return vehicleType;
    }
}
