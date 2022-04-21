package IntegrativeProject.DentalClinic.Service.impl;

import IntegrativeProject.DentalClinic.Entities.Dentist;
import IntegrativeProject.DentalClinic.Repository.IDentistRepository;
import IntegrativeProject.DentalClinic.Service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements IDentistService {

    @Autowired
    private IDentistRepository dentistRepository;
    @Autowired
    ObjectMapper objectMapper;


    @Override
    public IntegrativeProject.DentalClinic.Dto.DentistDTO findById(Integer id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        IntegrativeProject.DentalClinic.Dto.DentistDTO dentistDTO = null;
        if(dentist.isPresent())
            dentistDTO = objectMapper.convertValue(dentist, IntegrativeProject.DentalClinic.Dto.DentistDTO.class);
        return dentistDTO;
    }

    @Override
    public IntegrativeProject.DentalClinic.Dto.DentistDTO create(IntegrativeProject.DentalClinic.Dto.DentistDTO dentistDTO) {
       Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
       dentist = dentistRepository.save(dentist);
       return dentistDTO;
    }

    @Override
    public void deleteById(Integer id) {
dentistRepository.deleteById(id);
    }

    @Override
    public IntegrativeProject.DentalClinic.Dto.DentistDTO update(IntegrativeProject.DentalClinic.Dto.DentistDTO dentistDTO) {
        Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
        dentist = dentistRepository.save(dentist);
        return dentistDTO;
    }

    @Override
    public Set<IntegrativeProject.DentalClinic.Dto.DentistDTO> findAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<IntegrativeProject.DentalClinic.Dto.DentistDTO> dentistDTOS = new HashSet<>();
        for (Dentist dentist : dentists) {
            dentistDTOS.add(objectMapper.convertValue(dentist, IntegrativeProject.DentalClinic.Dto.DentistDTO.class));
        }
        return dentistDTOS;
    }
}
