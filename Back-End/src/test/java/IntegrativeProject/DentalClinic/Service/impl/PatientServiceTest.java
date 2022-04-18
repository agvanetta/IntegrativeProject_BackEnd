package IntegrativeProject.DentalClinic.Service.impl;

import IntegrativeProject.DentalClinic.DTO.PatientDTO;
import IntegrativeProject.DentalClinic.Service.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    private IPatientService patientService;

    @Test
    public void testCreatePatient() {

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Pedro");
        patientDTO.setSurname("Castro");
        patientDTO.setDni(1324);
        patientService.create(patientDTO);

        PatientDTO patientPedro = patientService.findById(1);


        assertTrue(patientPedro != null);

    }

    @Test
    public void testUpdatePatient() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Pedro");
        patientDTO.setSurname("Castro");
        patientDTO.setDni(1324);

        patientService.create(patientDTO);

        PatientDTO patientPedro = patientService.findById(1);
        patientPedro.setName("Pedro");
        patientPedro.setSurname("Castro");
        patientPedro.setDni(1324);

        patientService.update(patientPedro);

        PatientDTO patientPedro2 = patientService.findById(1);

        assertTrue(patientPedro2.getName().equals("Pedro"));
    }

    @Test
    public void testFindAll() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Pedro");
        patientDTO.setSurname("Castro");

        patientService.create(patientDTO);

        PatientDTO patientPedro = patientService.findById(1);

        assertTrue(patientPedro != null);
    }

    @Test
    public void testFindById() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Pedro");
        patientDTO.setSurname("Castro");
        patientDTO.setDni(1324);

        patientService.create(patientDTO);

        PatientDTO patientPedro = patientService.findById(1);

        assertTrue(patientPedro != null);
    }

    @Test
    public void testDeletePatient() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(1);
        patientDTO.setName("Pedro");
        patientDTO.setSurname("Castro");

        patientService.create(patientDTO);
        patientService.deleteById(1);

        PatientDTO patientPedro = patientService.findById(1);

        assertTrue(patientPedro == null);

    }

}