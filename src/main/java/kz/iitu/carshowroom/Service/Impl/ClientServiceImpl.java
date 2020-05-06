package kz.iitu.carshowroom.Service.Impl;

import kz.iitu.carshowroom.Entity.Client;
import kz.iitu.carshowroom.Entity.UserType;
import kz.iitu.carshowroom.Repositories.ClientRepository;
import kz.iitu.carshowroom.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService, UserDetailsService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    @Override
    public void creatClient(Client client) {
       client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.saveAndFlush(client);
    }

    @Override
    public void updateClient(long id, Client client) {
        Client clientDb = clientRepository.findById(id).orElse(null);
        if (clientDb !=null){
            clientRepository.saveAndFlush(clientDb );
        }
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.delete(clientRepository.findById(id).get());
    }

    @Override
    public Client findClientById(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public void updateClientType(UserType userType, long id) {
        Client client = clientRepository.findById(id).get();
        clientRepository.saveAndFlush(client);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findClientByUsername(username);
        if(client==null){
            throw new UsernameNotFoundException(username + "Not found");
        }
        return client;
    }


}
