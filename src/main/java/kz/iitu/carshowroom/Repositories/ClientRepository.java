package kz.iitu.carshowroom.Repositories;

import kz.iitu.carshowroom.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
/*
   List<Client> findClientByUsername(String username);
*/

   Client findClientByUsername(String name);

    @Query("select c from Client c where c.hasMembership=true")
    Client findClientByHasMembership();
}
