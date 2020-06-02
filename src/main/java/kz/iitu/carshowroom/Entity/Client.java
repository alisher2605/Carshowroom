package kz.iitu.carshowroom.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Client implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    private String gender;
    private String password;
    private int drivingExperience;
    private int drivingLicenceNo;
    @ManyToMany(mappedBy = "clients", fetch = FetchType.LAZY)
    private List<Vehicle> vehicleList;


    @OneToMany(mappedBy = "client")
    private List<UserType> userType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userType;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", drivingExperience=" + drivingExperience +
                ", drivingLicenceNo=" + drivingLicenceNo +
                '}';
    }
}


