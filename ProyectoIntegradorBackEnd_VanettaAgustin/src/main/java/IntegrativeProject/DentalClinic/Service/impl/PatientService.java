package IntegrativeProject.DentalClinic.Service.impl;

;

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
    public IntegrativeProject.DentalClinic.Dto.PatientDTO findById(Integer id) {

        Optional<Patient> patient = patientRepository.findById(id);
        IntegrativeProject.DentalClinic.Dto.PatientDTO patientDTO = null;
        if(patient.isPresent())
            patientDTO = objectMapper.convertValue(patient, IntegrativeProject.DentalClinic.Dto.PatientDTO.class);
        return patientDTO;
    }
// crear un usuario
    @Override
    public IntegrativeProject.DentalClinic.Dto.PatientDTO create(IntegrativeProject.DentalClinic.Dto.PatientDTO patientDTO) {
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
    public IntegrativeProject.DentalClinic.Dto.PatientDTO update(IntegrativeProject.DentalClinic.Dto.PatientDTO patientDTO) {
        Patient patient = objectMapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
        return patientDTO;

    }
// listar todos los usuarios
    @Override
    public Set<IntegrativeProject.DentalClinic.Dto.PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<IntegrativeProject.DentalClinic.Dto.PatientDTO> patientDTOS = new HashSet<>();
        for (Patient patient : patients) {
            patientDTOS.add(objectMapper.convertValue(patient, IntegrativeProject.DentalClinic.Dto.PatientDTO.class));
        }
        return patientDTOS;
    }

}
