package IntegrativeProject.DentalClinic.Service.impl;

import IntegrativeProject.DentalClinic.Dto.AppointmentDTO;
import IntegrativeProject.DentalClinic.Dto.DentistDTO;
import IntegrativeProject.DentalClinic.Dto.PatientDTO;
import IntegrativeProject.DentalClinic.Service.IAppointmentService;
import IntegrativeProject.DentalClinic.Service.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppointmentServiceTest {

    @Autowired
    private DentistService dentistService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private AppointmentService appointmentService;


    @Test
    public void testCreateAppointment(){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Agustin");
        patientDTO.setLastname("Vanetta");
        patientDTO.setDni(377732203);
        patientService.create(patientDTO);

        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Giovanni");
        dentistDTO.setLastname("Vanetta");
        dentistDTO.setRegister(11210);
        dentistService.create(dentistDTO);

        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(1);
        appointmentDTO.setDentist(dentistDTO);
        appointmentDTO.setPatient(patientDTO);
        appointmentDTO.setDate(LocalDate.now());
        appointmentDTO.setTime("15:00");
        appointmentService.create(appointmentDTO);
    }

    @Test
    public void testDeleteApp(){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Agustin");
        patientDTO.setLastname("Vanetta");
        patientDTO.setDni(377732203);
        patientService.create(patientDTO);

        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Giovanni");
        dentistDTO.setLastname("Vanetta");
        dentistDTO.setRegister(11210);
        dentistService.create(dentistDTO);

        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(1);
        appointmentDTO.setDentist(dentistDTO);
        appointmentDTO.setPatient(patientDTO);
        appointmentDTO.setDate(LocalDate.now());
        appointmentDTO.setTime("15:00");
        appointmentService.create(appointmentDTO);
        appointmentService.deleteById(appointmentDTO.getId());
        AppointmentDTO appointmentDTO1 = appointmentService.findById(1);

        assertTrue(appointmentDTO1 == null);
    }
}