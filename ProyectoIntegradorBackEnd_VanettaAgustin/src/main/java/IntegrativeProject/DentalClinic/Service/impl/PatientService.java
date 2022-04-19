package IntegrativeProject.DentalClinic.Service.impl;

;

import IntegrativeProject.DentalClinic.Dto.PatientDTO;
import IntegrativeProject.DentalClinic.Entities.Patient;
import IntegrativeProject.DentalClinic.Repository.IPatientRepository;
import IntegrativeProject.DentalClinic.Service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService implements IPatientService {



    @Autowired
    private IPatientRepository patientRepository;

    // vamos a mapear
    @Autowired
    ObjectMapper objectMapper;


// encontrar un usuario por id
    @Override
    public PatientDTO findById(Integer id) {

        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;
        if(patient.isPresent())
            patientDTO = objectMapper.convertValue(patient, PatientDTO.class);
        return patientDTO;
    }
// crear un usuario
    @Override
    public PatientDTO create(PatientDTO patientDTO) {
        Patient patient = objectMapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
        return patientDTO;

    }
// eliminar un usuario por id
    @Override
    public void deleteById(Integer id) {
        patientRepository.deleteById(id);
    }


// actualizar un usuario
    @Override
    public PatientDTO update(PatientDTO patientDTO) {
        Patient patient = objectMapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
        return patientDTO;

    }
// listar todos los usuarios
    @Override
    public Set<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientDTOS = new HashSet<>();
        for (Patient patient : patients) {
            patientDTOS.add(objectMapper.convertValue(patient, PatientDTO.class));
        }
        return patientDTOS;
    }

}
