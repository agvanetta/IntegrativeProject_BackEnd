package IntegrativeProject.DentalClinic.Dto;

import IntegrativeProject.DentalClinic.Entities.Dentist;
import IntegrativeProject.DentalClinic.Entities.Patient;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentDTO {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private LocalDate date;
    private String time;
}
