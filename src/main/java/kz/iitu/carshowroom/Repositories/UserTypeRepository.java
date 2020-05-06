package kz.iitu.carshowroom.Repositories;

import kz.iitu.carshowroom.Entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
