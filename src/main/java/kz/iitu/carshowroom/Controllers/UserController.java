package kz.iitu.carshowroom.Controllers;

import io.swagger.annotations.ApiOperation;
import kz.iitu.carshowroom.Entity.Client;
import kz.iitu.carshowroom.Entity.Vehicle;
import kz.iitu.carshowroom.Repositories.ClientRepository;
import kz.iitu.carshowroom.Repositories.VehicleRepository;
import kz.iitu.carshowroom.Service.Impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController  {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientServiceImpl clientService;

    @ApiOperation(value = "Returns list of users")
    @GetMapping("")
    public List<Client> clientList(){
        return clientService.getAllClients();
    }

    @ApiOperation(value = "Returns user with entered id")
    @GetMapping("/{id}")
    public Client clientListById(@PathVariable("id") Long id){
        if (id == null){
            throw new RuntimeException("Id must not be null");
        }
        return clientService.findClientById(id);
    }
    @ApiOperation(value = "Returns users with membership")
    @GetMapping("/membership")
    public Client memberClient(){
        return clientRepository.findClientByHasMembership();
    }

    @ApiOperation(value = "Returns user with entered username")
   // api/users/find/?username=aleisher
    @GetMapping("/find/")
    public void findClientByUserName(@RequestParam(name = "username") String username){
        if (username == null){
            throw new RuntimeException("Username should not be null");
        }
        else{
            clientService.loadUserByUsername(username);
        }

    }
    @ApiOperation(value = "Creates new user")
    @PostMapping("/create")
    public void newClient(@RequestBody Client client){
        if (client == null){
            throw new RuntimeException("Client object must not be null");
        }
        else{
            clientService.creatClient(client);
        }
    }
    @ApiOperation(value = "Updates user with entered id")
    @PutMapping("/{id}")
    public void   updateClient (@PathVariable Long id, @RequestBody Client  client){
        if (client == null || id == null){
            throw new RuntimeException("Client information and id must not be null");
        }
        else{
            clientService.updateClient(id, client);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        }
    }

    @ApiOperation(value = "Removes user with entered id")
    @DeleteMapping("/{id}")
    public void   removeClient (@PathVariable("id") Long id){
        if (id == null){
            throw new RuntimeException("Id must not be null");
        }
        else{
            clientService.deleteClient(id);
        }

    }

    @GetMapping("/make")
    public void createClientByUsernamePassword(String name,
                                           String password){
        Client client = new Client();
        client.setUsername(name);
        client.setPassword(password);
        clientService.creatClient(client);
    }
}
