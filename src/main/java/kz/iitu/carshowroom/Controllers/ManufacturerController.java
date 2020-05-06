package kz.iitu.carshowroom.Controllers;

import kz.iitu.carshowroom.Entity.Manufacturer;
import kz.iitu.carshowroom.Repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {
    @Autowired
    ManufacturerRepository manufacturerRepository;

    @GetMapping("")
    public List<Manufacturer>manufacturerList(){
        return manufacturerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Manufacturer manufacturerListById(@PathVariable("id") long id){
            return manufacturerRepository.findById(id).get();
    }

    // /manufacturers/find/?name=Mercedes
    @GetMapping("/find/")
    public List<Manufacturer>findManufacturerByName(@RequestParam(name = "name")String name){
        return manufacturerRepository.findManufacturerByName(name);
    }

    @PostMapping("/create")
    public Manufacturer newManufacturer(@RequestBody Manufacturer manufacturer){
        if (manufacturer.getName()== null || manufacturer.getCountry() == null){
            throw new RuntimeException("Manufacturer name and country should not be null");
        }
        return manufacturerRepository.saveAndFlush(manufacturer);
    }

    @PutMapping("/{id}")
    public Manufacturer updateManufacturer(@PathVariable int id, @RequestBody Manufacturer manufacturer){
        manufacturer.setManufacturerId(id);
        return manufacturerRepository.saveAndFlush(manufacturer );
    }

    @DeleteMapping("/{id}")
    public Manufacturer  removeBook(@PathVariable("id") int id){
        Manufacturer  manufacturer = this.manufacturerListById(id);
        manufacturerRepository.delete(manufacturer);
        return manufacturer;
    }
}
