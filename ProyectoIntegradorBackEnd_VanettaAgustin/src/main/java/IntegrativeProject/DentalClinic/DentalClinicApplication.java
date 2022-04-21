package IntegrativeProject.DentalClinic;

import IntegrativeProject.DentalClinic.Dto.AppointmentDTO;
import IntegrativeProject.DentalClinic.Dto.DentistDTO;
import IntegrativeProject.DentalClinic.Dto.PatientDTO;
import IntegrativeProject.DentalClinic.Service.impl.AppointmentService;
import IntegrativeProject.DentalClinic.Service.impl.DentistService;
import IntegrativeProject.DentalClinic.Service.impl.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;

import java.time.LocalDate;

@SpringBootApplication
public class DentalClinicApplication {


	public static void main(String[] args) {



		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(DentalClinicApplication.class, args);

	}

}
