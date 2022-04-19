package IntegrativeProject.DentalClinic.Service.impl;

import IntegrativeProject.DentalClinic.Dto.PatientDTO;
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
        patientDTO.setName("Agustin");
        patientDTO.setLastname("Vanetta");
        patientDTO.setDni(377732203);
        patientService.create(patientDTO);
        PatientDTO patient1 = patientService.findById(1);
        assertTrue(patient1 != null);
    }

    @Test
    public void testUpdatePatient() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Giovanni");
        patientDTO.setLastname("Vanetta");
        patientDTO.setDni(57353461);
        patientService.create(patientDTO);

        PatientDTO patientTest = patientService.findById(1);
        patientTest.setName("Giovanni");
        patientTest.setLastname("Vanetta");
        patientTest.setDni(57353461);
        patientService.update(patientTest);

        PatientDTO patientTest2 = patientService.findById(1);
        assertTrue(patientTest2.getName().equals("Giovanni"));
    }

    @Test
    public void testFindAll() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Agustin");
        patientDTO.setLastname("Vanetta");
        patientService.create(patientDTO);
        PatientDTO patientTest = patientService.findById(1);

        assertTrue(patientTest != null);
    }

    @Test
    public void testFindById() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Agustin");
        patientDTO.setLastname("Vanetta");
        patientDTO.setDni(37732203);
        patientService.create(patientDTO);
        PatientDTO patientTest = patientService.findById(1);

        assertTrue(patientTest != null);
    }

    @Test
    public void testDeletePatient() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(1);
        patientDTO.setName("Agustin");
        patientDTO.setLastname("Vanetta");
        patientService.create(patientDTO);
        patientService.deleteById(1);
        PatientDTO patientTest = patientService.findById(1);

        assertTrue(patientTest == null);
    }
}
