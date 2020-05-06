package kz.iitu.carshowroom;

import kz.iitu.carshowroom.Controllers.ManufacturerController;
import kz.iitu.carshowroom.Entity.Client;
import kz.iitu.carshowroom.Entity.Manufacturer;
import kz.iitu.carshowroom.Entity.Vehicle;
import kz.iitu.carshowroom.Repositories.ManufacturerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarshowroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarshowroomApplication.class, args);
	}

}
