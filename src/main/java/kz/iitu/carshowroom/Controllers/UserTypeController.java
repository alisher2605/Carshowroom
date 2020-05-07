package kz.iitu.carshowroom.Controllers;

import io.swagger.annotations.ApiOperation;
import kz.iitu.carshowroom.Entity.UserType;
import kz.iitu.carshowroom.Repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usertypes")
public class UserTypeController {
    @Autowired
    UserTypeRepository userTypeRepository;

    @ApiOperation(value = "Returns user type list")
    @GetMapping("")
    public List<UserType> clientTypeList(){
        return userTypeRepository.findAll();
    }
    @ApiOperation(value = "Returns user type with entered id")
    @GetMapping("/{id}")
    public UserType clientTypeListById(@PathVariable("id") long id){
        return userTypeRepository.findById(id).get();
    }

    @ApiOperation(value = "Creates new user type")
    @PostMapping("")
    public UserType newClientType(@RequestBody UserType userType){
        return userTypeRepository.saveAndFlush(userType);
    }

    @ApiOperation(value = "Updates user type with entered id")
    @PutMapping("/{id}")
    public UserType  updateClientType (@PathVariable long id, @RequestBody UserType  userType){
        userType.setUserTypeId(id);
        return userTypeRepository.saveAndFlush(userType);
    }

    @ApiOperation(value = "Removes user type with entered id")
    @DeleteMapping("/{id}")
    public UserType   removeClient (@PathVariable("id") long id){
        UserType  userType = this.clientTypeListById(id);
        userTypeRepository.delete(userType);
        return userType;
    }
}
