package IntegrativeProject.DentalClinic.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentDTO {

    private Integer id;
    private PatientDTO patient;
    private DentistDTO dentist;
    private LocalDate date;
    private String time;
}
