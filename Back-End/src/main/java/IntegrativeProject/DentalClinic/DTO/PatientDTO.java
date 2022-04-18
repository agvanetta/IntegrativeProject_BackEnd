package IntegrativeProject.DentalClinic.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private Integer dni;
    private LocalDate initDate;
    private AddressDTO address;
}
