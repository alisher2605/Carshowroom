package kz.iitu.carshowroom.Controllers;

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

    @GetMapping("")
    public List<Client> clientList(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client clientListById(@PathVariable("id") long id){
        return clientService.findClientById(id);
    }

    @GetMapping("/membership")
    public Client memberClient(){
        return clientRepository.findClientByHasMembership();
    }

   // api/users/find/?name=aleisher
    @GetMapping("/find/")
    public void findClientByUserName(@RequestParam(name = "name") String username){
         clientService.loadUserByUsername(username);
    }

    @PostMapping("/create")
    public void newClient(@RequestBody Client client){
         clientService.creatClient(client);
    }

    @PutMapping("/{id}")
    public void   updateClient (@PathVariable long id, @RequestBody Client  client){
         clientService.updateClient(id, client);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    }


    @DeleteMapping("/{id}")
    public void   removeClient (@PathVariable("id") long id){
        clientService.deleteClient(id);
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
