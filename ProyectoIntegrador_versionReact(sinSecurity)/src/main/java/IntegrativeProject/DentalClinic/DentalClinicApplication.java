package IntegrativeProject.DentalClinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;

@SpringBootApplication
public class DentalClinicApplication {


	public static void main(String[] args) {



		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(DentalClinicApplication.class, args);

	}

}
