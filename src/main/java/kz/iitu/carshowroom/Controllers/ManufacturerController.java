package kz.iitu.carshowroom.Controllers;

import io.swagger.annotations.ApiOperation;
import kz.iitu.carshowroom.Entity.Manufacturer;
import kz.iitu.carshowroom.Repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
@CrossOrigin(origins = "http://localhost:3000")
public class ManufacturerController {
    @Autowired
    ManufacturerRepository manufacturerRepository;

    @ApiOperation(value = "Returns the list of all manufacturers")
    @GetMapping("")
    public List<Manufacturer>manufacturerList(){
        return manufacturerRepository.findAll();
    }

    @ApiOperation(value = "Returns manufacturer with entered id")
    @GetMapping("/{id}")
    public Manufacturer manufacturerListById(@PathVariable("id") Long id){
        if (id == null){
            throw new RuntimeException("Id name should not be null");
        }
        else{
            return manufacturerRepository.findById(id).get();
        }
    }

    @ApiOperation(value = "Returns manufacturer with entered name")
    // /manufacturers/find/?name=Mercedes
    @GetMapping("/find/")
    public List<Manufacturer>findManufacturerByName(@RequestParam(name = "name")String name){
        if (name == null){
            throw new RuntimeException("Manufacturer name should not be null");
        }
        else{
            return manufacturerRepository.findManufacturerByName(name);
        }
    }

    @ApiOperation(value = "Creates new manufacturer")
    @PostMapping("/create")
    public Manufacturer newManufacturer(@RequestBody Manufacturer manufacturer){
        if (manufacturer.getName()== null || manufacturer.getCountry() == null){
            throw new RuntimeException("Manufacturer name and country should not be null");
        }
        else{
            return manufacturerRepository.saveAndFlush(manufacturer);
        }
    }

    @ApiOperation(value = "Updates manufacturer with entered id")
    @PutMapping("/{id}")
    public Manufacturer updateManufacturer(@PathVariable Long id, @RequestBody Manufacturer manufacturer){
        if (id == null || manufacturer == null){
            throw new RuntimeException("Manufacturer information and id must not be null");
        }
        else{
            manufacturer.setManufacturerId(id);
            return manufacturerRepository.saveAndFlush(manufacturer );
        }
    }
    @ApiOperation(value = "Removes manufacturer with entered id")
    @DeleteMapping("/{id}")
    public Manufacturer removeManufacturer(@PathVariable("id") Long id){
        if (id == null){
            throw new RuntimeException("Manufacturer id must not be null");
        }
        else{
            Manufacturer  manufacturer = this.manufacturerListById(id);
            manufacturerRepository.delete(manufacturer);
            return manufacturer;
        }
    }
}
